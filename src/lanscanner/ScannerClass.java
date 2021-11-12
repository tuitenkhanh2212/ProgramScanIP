/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanscanner;

import GUI.MainFrame;

/**
 *
 * @author Tanveer
 */
public class ScannerClass implements Runnable{

    MainFrame mFrame;
    Thread t;
    PingClass ping[];
    IpGenerator ipGen;

    public ScannerClass (String[] fromIP, String[] toIP, MainFrame gui){
        this.mFrame = gui;
        ping = new PingClass[50];

        for(int i = 0; i < 50; i++){
            ping[i] = new PingClass();
        }

        ipGen = new IpGenerator(fromIP, toIP);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        String ip;
        int i;

        while(true){
            for(i = 0; i < 50; i++){
                if(ping[i].status == 1) {
                    ip = ipGen.ipGenerate();

                    if((ip.equals("-1") == true || mFrame.state == 1)){
                        break;
                    } else {
                        ping[i].initiate(ip, this.mFrame);
                    }
                }
            }

            if(i < 50){
                break;
            }
        }

        if(mFrame.state == 1){
            for(i = 0; i < 50; i++){
                if(ping[i].t.isAlive() == true) {
                    ping[i].t.stop();
                }
            }
        }
    }

}
