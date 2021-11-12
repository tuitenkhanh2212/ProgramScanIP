/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Sep 10, 2011, 1:37:34 AM
 */
package GUI;

import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lanscanner.CommandLine;
import lanscanner.IpObject;
import lanscanner.ScannerClass;

/**
 *
 * @author Tanveer
 */
public class MainFrame extends javax.swing.JFrame {

    public ArrayList<IpObject> scanList;
    public ArrayList<IpObject> sharedDevices;
    DefaultTableModel tbmdl;
    public int flag, state;
    ScannerClass scan;
    String fromIP, toIP;
    Vector sharedFoldersListData = new Vector();
    String currentIP;
    CommandLine command = new CommandLine();
    public int devices = 0;

    public MainFrame() {

        initComponents();

        tbmdl = new DefaultTableModel(new Object[][]{}, new String[]{"IP Adress", "Host Name"});
        scanResultList.setModel(tbmdl);
        state = 0;
        rBtnScanInRange.setSelected(true);
        rBtn16.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbHostName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbIpAddress = new javax.swing.JLabel();
        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroupThread = new javax.swing.ButtonGroup();
        rangeToolBar = new javax.swing.JToolBar();
        statusToolBar = new javax.swing.JToolBar();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFrom1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTo1 = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        deviceListScrollPane = new javax.swing.JScrollPane();
        scanResultList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbHostName1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbIpAddress1 = new javax.swing.JLabel();
        txtFrom2 = new javax.swing.JTextField();
        txtFrom3 = new javax.swing.JTextField();
        txtFrom4 = new javax.swing.JTextField();
        txtTo2 = new javax.swing.JTextField();
        txtTo3 = new javax.swing.JTextField();
        txtTo4 = new javax.swing.JTextField();
        rBtnScanAll = new javax.swing.JRadioButton();
        rBtnScanInRange = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        devicesLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rBtn16 = new javax.swing.JRadioButton();
        rBtn32 = new javax.swing.JRadioButton();
        rBtn64 = new javax.swing.JRadioButton();
        rBtn128 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("PROGRAM SCANIP");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Your Ip Address :");

        lbHostName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHostName.setText("Hostname");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Your Host Name :");

        lbIpAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbIpAddress.setText("IP");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program Scan IP ");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        rangeToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rangeToolBar.setRollover(true);

        statusToolBar.setRollover(true);

        startButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 102, 0));
        startButton.setText("Start Scan");
        startButton.setToolTipText("Click to Start Scanning");
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stopButton.setForeground(new java.awt.Color(204, 0, 0));
        stopButton.setText("Stop Scan");
        stopButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("IP Ranges from:");

        txtFrom1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFrom1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFrom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFrom1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("To:");

        txtTo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTo1KeyTyped(evt);
            }
        });

        statusLabel.setText("Status : Ready");

        scanResultList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        scanResultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IP Adress", "Host Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scanResultList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scanResultList.setGridColor(new java.awt.Color(255, 255, 255));
        scanResultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanResultListMouseClicked(evt);
            }
        });
        deviceListScrollPane.setViewportView(scanResultList);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("PROGRAM SCANIP");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Your Ip Address :");

        lbHostName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHostName1.setText("Hostname");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Your Host Name :");

        lbIpAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbIpAddress1.setText("IP");

        txtFrom2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFrom2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFrom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFrom2KeyTyped(evt);
            }
        });

        txtFrom3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFrom3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFrom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFrom3KeyTyped(evt);
            }
        });

        txtFrom4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFrom4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFrom4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFrom4KeyTyped(evt);
            }
        });

        txtTo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTo2KeyTyped(evt);
            }
        });

        txtTo3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTo3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTo3KeyTyped(evt);
            }
        });

        txtTo4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTo4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTo4KeyTyped(evt);
            }
        });

        buttonGroup.add(rBtnScanAll);
        rBtnScanAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rBtnScanAll.setText("Scan All");
        rBtnScanAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnScanAllActionPerformed(evt);
            }
        });

        buttonGroup.add(rBtnScanInRange);
        rBtnScanInRange.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rBtnScanInRange.setText("Scan in Range");
        rBtnScanInRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnScanInRangeActionPerformed(evt);
            }
        });

        jLabel6.setText("Devices total scan:");

        devicesLabel.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Select number of thread");

        buttonGroupThread.add(rBtn16);
        rBtn16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rBtn16.setText("16 Threads");

        buttonGroupThread.add(rBtn32);
        rBtn32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rBtn32.setText("32 Threads");

        buttonGroupThread.add(rBtn64);
        rBtn64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rBtn64.setText("64 Threads");

        buttonGroupThread.add(rBtn128);
        rBtn128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rBtn128.setText("128 Threads");

        fileMenu.setText("File");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rangeToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rBtn16)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTo1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFrom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(rBtn64)
                                    .addComponent(rBtn32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFrom2)
                                    .addComponent(txtTo2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFrom3)
                                    .addComponent(txtTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFrom4)
                                    .addComponent(txtTo4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rBtnScanAll)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rBtnScanInRange))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(rBtn128)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbIpAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHostName1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(statusLabel)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(devicesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deviceListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rangeToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHostName1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIpAddress1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devicesLabel)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deviceListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rBtnScanAll)
                            .addComponent(rBtnScanInRange))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrom3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrom4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTo4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(rBtn16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtn32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtn64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtn128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        if (txtFrom1.getText().isEmpty() || 
            txtFrom2.getText().isEmpty() || 
            txtFrom3.getText().isEmpty() || 
            txtFrom4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the starting IP range");
            return;
        }
        if (txtTo1.getText().isEmpty() ||
            txtTo2.getText().isEmpty() ||
            txtTo3.getText().isEmpty() ||
            txtTo4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ending IP range");
            return;
        }
        startButton.setText("Scanning");
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        scanResultList.clearSelection();
        statusLabel.setText("Status : Scanning");

        state = flag = 0;
        tbmdl.setRowCount(0);
        scanList = new ArrayList<IpObject>();

        fromIP = txtFrom1.getText() + "." + txtFrom2.getText() + "." + txtFrom3.getText() + "." + txtFrom4.getText();
        toIP = txtTo1.getText() + "." + txtTo2.getText() + "." + txtTo3.getText() + "." + txtTo4.getText();
        String[] initialIP = fromIP.split("\\.");
        String[] finalIP = toIP.split("\\.");

        this.scan = new ScannerClass(initialIP, finalIP, this);
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        state = 1;
        startButton.setText("Start Scan");
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        statusLabel.setText("Status : Stopped");

    }//GEN-LAST:event_stopButtonActionPerformed

    private void txtFrom1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFrom1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtFrom1KeyTyped

    private void txtTo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTo1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtTo1KeyTyped

    private void scanResultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanResultListMouseClicked
        // TODO add your handling code here:
//        if (evt.getClickCount() == 1) {
//
//            sharedFoldersListData.clear();
//            pingButton.setEnabled(true);
//
//            int row = scanResultList.rowAtPoint(evt.getPoint());
//            String selectedIP = scanResultList.getValueAt(row, 0).toString();
//            currentIP = selectedIP;
//            pingButton.setEnabled(true);
//            showSharedFolders(selectedIP);
//        }

        /*if (evt.getClickCount() == 1) {
            int row = scanResultList.rowAtPoint(evt.getPoint());
            String selectedIP = scanResultList.getValueAt(row, 0).toString();
            currentIP = selectedIP;
            pingButton.setEnabled(true);
        }*/

    }//GEN-LAST:event_scanResultListMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
            InetAddress myIP = InetAddress.getLocalHost();
            lbHostName1.setText(myIP.getHostName().toString());
            lbIpAddress1.setText(myIP.getHostAddress().toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtFrom2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFrom2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtFrom2KeyTyped

    private void txtFrom3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFrom3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtFrom3KeyTyped

    private void txtFrom4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFrom4KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtFrom4KeyTyped

    private void txtTo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTo2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtTo2KeyTyped

    private void txtTo3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTo3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtTo3KeyTyped

    private void txtTo4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTo4KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == evt.VK_BACK_SPACE) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtTo4KeyTyped

    private void rBtnScanAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnScanAllActionPerformed
        txtFrom4.setText("0");
        txtFrom4.setEditable(false);
        txtTo4.setText("255");
        txtTo4.setEditable(false);
    }//GEN-LAST:event_rBtnScanAllActionPerformed

    private void rBtnScanInRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnScanInRangeActionPerformed
        txtFrom4.setText("");
        txtFrom4.setEditable(true);
        txtTo4.setText("");
        txtTo4.setEditable(true);
    }//GEN-LAST:event_rBtnScanInRangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                MainFrame mf = new MainFrame();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroupThread;
    private javax.swing.JScrollPane deviceListScrollPane;
    private javax.swing.JLabel devicesLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbHostName;
    private javax.swing.JLabel lbHostName1;
    private javax.swing.JLabel lbIpAddress;
    private javax.swing.JLabel lbIpAddress1;
    private javax.swing.JRadioButton rBtn128;
    private javax.swing.JRadioButton rBtn16;
    private javax.swing.JRadioButton rBtn32;
    private javax.swing.JRadioButton rBtn64;
    private javax.swing.JRadioButton rBtnScanAll;
    private javax.swing.JRadioButton rBtnScanInRange;
    private javax.swing.JToolBar rangeToolBar;
    private javax.swing.JTable scanResultList;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToolBar statusToolBar;
    private javax.swing.JButton stopButton;
    private javax.swing.JTextField txtFrom1;
    private javax.swing.JTextField txtFrom2;
    private javax.swing.JTextField txtFrom3;
    private javax.swing.JTextField txtFrom4;
    private javax.swing.JTextField txtTo1;
    private javax.swing.JTextField txtTo2;
    private javax.swing.JTextField txtTo3;
    private javax.swing.JTextField txtTo4;
    // End of variables declaration//GEN-END:variables

    public void insertObj(IpObject obj) {

        int i = scanResultList.getRowCount();
        tbmdl.addRow(new Object[]{});
        scanResultList.setValueAt(obj.getIpAdress(), i, 0);
        scanResultList.setValueAt(obj.getHostName(), i, 1);
        devices++;
        devicesLabel.setText("" + devices + "");
    }

    public void showSharedFolders(String s) {
        String[] netViewResult;
        String str = command.netView(s);
        netViewResult = str.split("\n");

        if (netViewResult.length > 0) {
            if (netViewResult[0].equals("Shared resources at \\\\" + s)) {
                String[] temp1 = str.split("-------------------------------------------------------------------------------");
                String[] temp2 = temp1[1].split("\n");

                for (int i = 0; i < temp2.length; i++) {
                    if (temp2[i].contains(" Disk ")) {
                        String[] temp3 = temp2[i].split(" Disk ");
                        sharedFoldersListData.add(temp3[0]);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "IP " + s + " has no shared folders");
            }
        } else {
            JOptionPane.showMessageDialog(null, "IP " + s + " has no shared folders");
        }
    }
}
