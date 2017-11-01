 
package Attendance;

import ganug_restapi.URLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector; 
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import java.lang.NoSuchMethodException;

public class Auth extends javax.swing.JFrame {
 
    public XmlRpcClient xmlRpcClient;
    public String serverUrl;
    public Vector<String> vector;
    private void initUsersList() throws MalformedURLException{
        jCbName.addItem("melina");
        jCbName.addItem("dian");
        jCbName.addItem("GaNuG");
        jCbName.addItem("fawwas");
        serverUrl = "http://192.168.173.185:1718/RPC2"; 
        xmlRpcClient = new XmlRpcClient(serverUrl);
        vector = new Vector<String>();
    }
    public Auth() throws MalformedURLException {
        initComponents();
        initUsersList();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCbStatus = new javax.swing.JComboBox();
        jTf_Report = new javax.swing.JTextField();
        jCbName = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Avaible", "Break", "Unavaible", "check" }));
        jCbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCbName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTf_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTf_Report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbStatusActionPerformed
        String status= new String(),name= new String(),edi = new String();
        if(jCbName.getSelectedIndex()==0){
            edi = "22";
        }if(jCbName.getSelectedIndex()==1){
            edi = "24";
        }if(jCbName.getSelectedIndex()==2){
            edi = "26";
        }if(jCbName.getSelectedIndex()==3){
            edi = "28";
        }if(jCbName.getSelectedIndex()==4){
            edi = "30";
        }if(jCbName.getSelectedIndex()==5){
            edi = "6";
        } 
        
        name = (String) jCbName.getSelectedItem();
        if(jCbStatus.getSelectedIndex()==0){
            status = "841bfd1d675c858289a0b835345a2ca8";
        }if(jCbStatus.getSelectedIndex()==1){
            status = "e4c38d6d45baf080943d323dd51a2ce8";
        }if(jCbStatus.getSelectedIndex()==2){
            status = "ab59297e38b7ae174837a5645b18cd46";
        }if(jCbStatus.getSelectedIndex()==3){
            try { 
                java.awt.Desktop.getDesktop().browse(new URI("http://localhost/Attendance/rest/api.php/log?filter=name,eq,"+jCbName.getSelectedItem()+"&&transform=1"));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                vector.removeAllElements();
                vector.addElement(edi); 
                vector.addElement(name); 
                vector.addElement(status); 
                //String hasil = (String) xmlRpcClient.execute("server.sendGet", vector);
                jTf_Report.setText((String) xmlRpcClient.execute("absen.sendGet", vector));
                //jTf_Report.setText(new URLConnection().sendGet(edi, name,status));
            } catch (XmlRpcException ex) {
                Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_jCbStatusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { 
                    System.out.print("Dev By Artoering Team \n Will Open In . . .");
                    for(int xx=5;xx>=0;xx--){
                        //System.out.println(xx);
                        System.out.print(xx+"...");
                        Thread.sleep(1000);
                    } 
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new Auth().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCbName;
    private javax.swing.JComboBox jCbStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTf_Report;
    // End of variables declaration//GEN-END:variables
}
