/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lanscanner;

import GUI.MainFrame;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanveer
 */
public class PingClass implements Runnable {

    Thread t;
    int status;
    MainFrame mainGui;
    IpObject ipObj;
    String ip;
    CommandLine cm = new CommandLine();

    public PingClass() {
        status = 1;
    }

    public void initiate(String s, MainFrame gui) {
        this.ip = s;
        ipObj = new IpObject();
        ipObj.setIpAdress(ip);
        this.mainGui = gui;
        this.status = 0;
        t = new Thread(this);
        t.start();

    }

    public boolean isReachable(String s) {
        boolean reachable = false;
        try {
            InetAddress adr = InetAddress.getByName(s);
            ipObj.setHostName(adr.getHostName());
            reachable = adr.isReachable(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reachable;
    }

    public String getMACadress(String s) {

        String result = "";
        try {
            String nbtstatResult = cm.nbtStat(s);
            String[] temp1 = nbtstatResult.split("---------------------------------------------");

            String[] temp2 = null;
            String[] temp3 = null;

            if (temp1.length <= 1) {
                result = "MAC adress not found";
            } else {
                temp2 = temp1[1].split("\\=");
                temp3 = temp2[1].split("\n");
                result = temp3[0];
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + " in \"getMACadress(String s)\" of " + s);
        }

        return result;
    }

    public boolean isSharred() throws IOException {

        String str;
        str = cm.runCMD("net view \\\\" + ip);
        str = str.trim();

        if (str.endsWith("The command completed successfully.") == true) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {

        if (isReachable(ipObj.getIpAdress()) == true) {

            try {
                if (isSharred() == true) {
                    ipObj.setStatus("Shared");
                } else {
                    ipObj.setStatus("Files not shared");
                }

                String mac = getMACadress(ip);
                ipObj.setMacAdress(mac);
                
            } catch (IOException ex) {
                Logger.getLogger(PingClass.class.getName()).log(Level.SEVERE, null, ex);
            }


            try {
                if (isSharred() == true) {
                    mainGui.sharedDevices.add(ipObj);
                }
            } catch (IOException ex) {
                Logger.getLogger(PingClass.class.getName()).log(Level.SEVERE, null, ex);
            }

            mainGui.scanList.add(ipObj);

            if (mainGui.flag == 0) {
                mainGui.insertObj(ipObj);

                
            }
        }
        this.status = 1;
    }
}
