/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lanscanner;

import java.io.Serializable;

/**
 *
 * @author Tanveer
 */
public class IpGenerator implements Serializable {

    String lastIpAdress;
    int a, b, c, d;
    int w, x, y, z;
    boolean endIP, firstIP;

    public IpGenerator(String str1[], String str2[]) {

        endIP = firstIP = false;
        a = Integer.parseInt(str1[0]);
        b = Integer.parseInt(str1[1]);
        c = Integer.parseInt(str1[2]);
        d = Integer.parseInt(str1[3]);

        w = Integer.parseInt(str2[0]);
        x = Integer.parseInt(str2[1]);
        y = Integer.parseInt(str2[2]);
        z = Integer.parseInt(str2[3]);

        lastIpAdress = String.valueOf(w) + "."
                + String.valueOf(x) + "."
                + String.valueOf(y) + "."
                + String.valueOf(z);

    }

    synchronized String ipGenerate() {

        String str = null;
        if (firstIP == false) {
            firstIP = true;
            return String.valueOf(a) + "."
                    + String.valueOf(b) + "."
                    + String.valueOf(c) + "."
                    + String.valueOf(d);
        }
        if (d + 1 > 255) {
            if (c + 1 > 255) {
                if (b + 1 > 255) {
                    b = 0;
                    c = 0;
                    d = 0;
                    a++;
                } else {
                    d = 0;
                    c = 0;
                    b++;
                }
            } else {
                c++;
                d = 0;
            }
        } else {
            d++;
        }


        str = String.valueOf(a) + "."
                + String.valueOf(b) + "."
                + String.valueOf(c) + "."
                + String.valueOf(d);

        if (endIP == false) {
            if (str.equals(lastIpAdress) == true) {
                endIP = true;
            }
            return str;
        } else {
            return "-1";
        }

    }
}
