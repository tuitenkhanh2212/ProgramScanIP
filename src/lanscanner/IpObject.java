/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanscanner;

/**
 *
 * @author Tanveer
 */
public class IpObject {
    private String ipAdress;
    private String hostName;
    private String status;
    private String macAdress;

    public IpObject() {
    }

    public IpObject(String ipAdress, String hostName, String status, String macAdress) {
        this.ipAdress = ipAdress;
        this.hostName = hostName;
        this.status = status;
        this.macAdress = macAdress;
    }

    /**
     * @return the ipAdress
     */
    public String getIpAdress() {
        return ipAdress;
    }

    /**
     * @param ipAdress the ipAdress to set
     */
    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the macAdress
     */
    public String getMacAdress() {
        return macAdress;
    }

    /**
     * @param macAdress the macAdress to set
     */
    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }



    
}
