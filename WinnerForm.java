/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.government.election.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lynford
 */
public class WinnerForm extends javax.swing.JFrame {
    
    public Connection con;
    public Statement st;

    /**
     * Creates new form WinnerForm
     */
    public WinnerForm() {
        initComponents();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
        
        getPresidentWInner();
        getVice_PresidentWInner();
        getSecretaryWInner();
        getTreasurerWInner();
        getAuditorWInner();
        getPROWInner();
    }
    
   
    
    //get presidential election Result
    public void getPresidentWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'President' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                lastname.setText(lname);
                firstname.setText(fname);
                position.setText(pos);
                points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    //get vice presidential election Result
    public void getVice_PresidentWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'Vice-President' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                vp_lastname.setText(lname);
                vp_firstname.setText(fname);
                vp_position.setText(pos);
                vp_points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    //get vice presidential election Result
    public void getSecretaryWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'Secretary' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                sec_lastname.setText(lname);
                sec_firstname.setText(fname);
                sec_position.setText(pos);
                sec_points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    //get treasurer
    public void getTreasurerWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'Treasurer' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                tres_lastname.setText(lname);
                tres_firstname.setText(fname);
                tres_position.setText(pos);
                tres_points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    //get auditor
    public void getAuditorWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'Auditor' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                audi_lastname.setText(lname);
                audi_firstname.setText(fname);
                audi_position.setText(pos);
                audi_points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
     public void getPROWInner(){
        
        try{

            String query = " SELECT * FROM voters WHERE position = 'PRO' ORDER BY -number_of_votes limit 1 ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
               
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String pos = rs.getString("position");
                String total = rs.getString("number_of_votes");
                
                pro_lastname.setText(lname);
                pro_firstname.setText(fname);
                pro_position.setText(pos);
                pro_points.setText(total);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        vp_lastname = new javax.swing.JLabel();
        vp_firstname = new javax.swing.JLabel();
        vp_position = new javax.swing.JLabel();
        vp_points = new javax.swing.JLabel();
        sec_lastname = new javax.swing.JLabel();
        sec_firstname = new javax.swing.JLabel();
        sec_position = new javax.swing.JLabel();
        sec_points = new javax.swing.JLabel();
        tres_lastname = new javax.swing.JLabel();
        tres_firstname = new javax.swing.JLabel();
        tres_position = new javax.swing.JLabel();
        tres_points = new javax.swing.JLabel();
        audi_lastname = new javax.swing.JLabel();
        audi_firstname = new javax.swing.JLabel();
        audi_position = new javax.swing.JLabel();
        audi_points = new javax.swing.JLabel();
        pro_lastname = new javax.swing.JLabel();
        pro_firstname = new javax.swing.JLabel();
        pro_position = new javax.swing.JLabel();
        pro_points = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Winner");

        lastname.setText("lname");

        firstname.setText("fname");

        position.setText("position");

        points.setText("points");

        vp_lastname.setText("lname");

        vp_firstname.setText("fname");

        vp_position.setText("position");

        vp_points.setText("points");

        sec_lastname.setText("lname");

        sec_firstname.setText("fname");

        sec_position.setText("secpos");

        sec_points.setText("points");

        tres_lastname.setText("lname");

        tres_firstname.setText("fname");

        tres_position.setText("secpos");

        tres_points.setText("points");

        audi_lastname.setText("lname");

        audi_firstname.setText("fname");

        audi_position.setText("secpos");

        audi_points.setText("points");

        pro_lastname.setText("lname");

        pro_firstname.setText("fname");

        pro_position.setText("secpos");

        pro_points.setText("points");

        jMenu1.setText("Return");

        jMenuItem1.setText("Admin Panel");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vp_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(vp_firstname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vp_position)
                                .addGap(18, 18, 18)
                                .addComponent(vp_points))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastname)
                                .addGap(18, 18, 18)
                                .addComponent(firstname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(position)
                                .addGap(18, 18, 18)
                                .addComponent(points))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sec_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(sec_firstname)
                                .addGap(18, 18, 18)
                                .addComponent(sec_position)
                                .addGap(18, 18, 18)
                                .addComponent(sec_points))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tres_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(tres_firstname)
                                .addGap(18, 18, 18)
                                .addComponent(tres_position)
                                .addGap(18, 18, 18)
                                .addComponent(tres_points))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(audi_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(audi_firstname)
                                .addGap(18, 18, 18)
                                .addComponent(audi_position)
                                .addGap(18, 18, 18)
                                .addComponent(audi_points))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pro_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(pro_firstname)
                                .addGap(18, 18, 18)
                                .addComponent(pro_position)
                                .addGap(18, 18, 18)
                                .addComponent(pro_points))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(position)
                    .addComponent(points)
                    .addComponent(firstname)
                    .addComponent(lastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vp_lastname)
                    .addComponent(vp_firstname)
                    .addComponent(vp_position)
                    .addComponent(vp_points))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sec_lastname)
                    .addComponent(sec_firstname)
                    .addComponent(sec_position)
                    .addComponent(sec_points))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tres_lastname)
                    .addComponent(tres_firstname)
                    .addComponent(tres_position)
                    .addComponent(tres_points))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(audi_lastname)
                    .addComponent(audi_firstname)
                    .addComponent(audi_position)
                    .addComponent(audi_points))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pro_lastname)
                    .addComponent(pro_firstname)
                    .addComponent(pro_position)
                    .addComponent(pro_points))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        
         new MainForm().setVisible(true);
         new MainForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         new MainForm().setLocationRelativeTo(null);
         this.dispose();
                    
         new WinnerForm().setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(WinnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinnerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel audi_firstname;
    private javax.swing.JLabel audi_lastname;
    private javax.swing.JLabel audi_points;
    private javax.swing.JLabel audi_position;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel points;
    private javax.swing.JLabel position;
    private javax.swing.JLabel pro_firstname;
    private javax.swing.JLabel pro_lastname;
    private javax.swing.JLabel pro_points;
    private javax.swing.JLabel pro_position;
    private javax.swing.JLabel sec_firstname;
    private javax.swing.JLabel sec_lastname;
    private javax.swing.JLabel sec_points;
    private javax.swing.JLabel sec_position;
    private javax.swing.JLabel tres_firstname;
    private javax.swing.JLabel tres_lastname;
    private javax.swing.JLabel tres_points;
    private javax.swing.JLabel tres_position;
    private javax.swing.JLabel vp_firstname;
    private javax.swing.JLabel vp_lastname;
    private javax.swing.JLabel vp_points;
    private javax.swing.JLabel vp_position;
    // End of variables declaration//GEN-END:variables
}
