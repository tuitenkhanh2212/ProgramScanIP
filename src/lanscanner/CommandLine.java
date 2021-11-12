/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lanscanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanveer
 */
public class CommandLine {

    public CommandLine() {
    }

    public String getProcessOutput(InputStreamReader processInputStream) throws IOException {

        BufferedReader br = new BufferedReader(processInputStream);
        String result = "";

        try {

            while (true) {

                String temp = br.readLine();
                if (temp == null) {
                    break;
                } else if (temp.equalsIgnoreCase("")) {
                    continue;
                }

                result += temp + "\n";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return result;
    }

    public String runCMD(String s) {

        String result = "";
        Runtime rt = Runtime.getRuntime();
        Process process;

        try {
            process = rt.exec(s);
            result = getProcessOutput(new InputStreamReader(process.getInputStream()));
            //process.waitFor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return result;
    }

    public String ping(String s) {
        return runCMD("ping -n 1 " + s);
    }

    public String netView(String s) {
        return runCMD("net view \\\\" + s);
    }

    public String nbtStat(String s) {
        return runCMD("nbtstat -a " + s);
    }

    public void explorerView(String s) {
        runCMD("explorer.exe \\\\" + s);
    }

    public String getMACadress(String s) {

        String result = "";
        try {
            String nbtstatResult = nbtStat(s);
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

    /*public boolean pingProcessResult(String s, String ip) {

        if (s.contains("Reply from " + ip) == true) {
            return true;
        } else {
            return false;
        }
    }*/
}
