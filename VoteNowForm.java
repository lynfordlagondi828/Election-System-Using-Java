/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.government.election.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lynford
 */
public class VoteNowForm extends javax.swing.JFrame {
    
     public Connection con;
     public Statement st;
    /**
     * Creates new form VoteNowForm
     */
    public VoteNowForm() {
        initComponents();
        
         
         
         
    }

    VoteNowForm(String ssid) {
         initComponents();
        user_id.setText(ssid);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
            
            
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
        
        bind_combo_box_for_president();
         bind_combo_box_for_vice_president();
         getSecretary();
         getTreasurer();
         getAuditor();
         getPRO();
    }

    
    private void bind_combo_box_for_president(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'President'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                
                String fullName = rs.getString("fullname");
               
               
                combo_president.addItem(fullName);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    private void bind_combo_box_for_vice_president(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'Vice-President'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String fullname = rs.getString("fullname");
               
                jComboBox1.addItem(fullname);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    //get secretary
    private void getSecretary(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'Secretary'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String fullname = rs.getString("fullname");
               
                combo_secretary.addItem(fullname);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    //get secretary
    private void getTreasurer(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'Treasurer'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String fullname = rs.getString("fullname");
               
               combo_tres.addItem(fullname);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    //get auditor
    private void getAuditor(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'Auditor'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String fullname = rs.getString("fullname");
               combo_auditor.addItem(fullname);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
    
    //get pro
     private void getPRO(){
        
       try{
           
           String sql = "SELECT * FROM voters WHERE position = 'PRO'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String fullname = rs.getString("fullname");
               combo_pro.addItem(fullname);
               
            }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
     // get the connection
   public Connection getConnection()
   {
       Connection conn;
       try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
           return conn;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
      // Execute The Insert Update And Delete Querys
   public void executeSQlQuery(String query, String message)
   {
       Connection connection = getConnection();
       Statement statement;
       
       try{
           statement = connection.createStatement();
           if((statement.executeUpdate(query)) == 1)
           {
              
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
               
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
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
        jLabel2 = new javax.swing.JLabel();
        combo_president = new javax.swing.JComboBox<>();
        selected_president = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        selected_vice_pres = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combo_secretary = new javax.swing.JComboBox<>();
        selected_sec = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_tres = new javax.swing.JComboBox<>();
        selected_tres = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_auditor = new javax.swing.JComboBox<>();
        selected_audi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_pro = new javax.swing.JComboBox<>();
        selected_pro = new javax.swing.JLabel();
        user_id = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vote Wisely");

        jLabel2.setText("President");

        combo_president.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        combo_president.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_presidentActionPerformed(evt);
            }
        });

        selected_president.setText("selected president");

        jLabel3.setText("Vice-President");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        selected_vice_pres.setText("selected vice prse");

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Secretary");

        combo_secretary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        combo_secretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_secretaryActionPerformed(evt);
            }
        });

        selected_sec.setText("selected sec");

        jLabel5.setText("Treasurer");

        combo_tres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        combo_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tresActionPerformed(evt);
            }
        });

        selected_tres.setText("selected tres");

        jLabel6.setText("Auditor");

        combo_auditor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        combo_auditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_auditorActionPerformed(evt);
            }
        });

        selected_audi.setText("selected audi");

        jLabel7.setText("P.R.O");

        combo_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    " }));
        combo_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_proActionPerformed(evt);
            }
        });

        selected_pro.setText("select pro");

        user_id.setText("userId");

        jMenu1.setText("Return");

        jMenuItem1.setText("Main");
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_auditor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_secretary, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_president, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(user_id))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected_president, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selected_vice_pres))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selected_sec)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(selected_audi)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_pro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_tres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selected_tres, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selected_pro, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(user_id))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_president, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_president)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_vice_pres))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_secretary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_sec)
                    .addComponent(jLabel5)
                    .addComponent(combo_tres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_tres))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_auditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_audi)
                    .addComponent(jLabel7)
                    .addComponent(combo_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selected_pro))
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_presidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_presidentActionPerformed
        // TODO add your handling code here:
        
        String selectedPres = combo_president.getSelectedItem().toString();
        selected_president.setText(selectedPres);
    }//GEN-LAST:event_combo_presidentActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        String vp = jComboBox1.getSelectedItem().toString();
        selected_vice_pres.setText(vp);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
            
           String pres = selected_president.getText();
           String vp  = selected_vice_pres.getText();
           String sec = selected_sec.getText();
           String tres = selected_tres.getText();
           String auditor = selected_audi.getText();
           String pro = selected_pro.getText();
           
           
           
           
           if(pres.equals("")){
               
                JOptionPane optionPane = new JOptionPane("Please select your President.!", JOptionPane.ERROR_MESSAGE);    
                 JDialog dialog = optionPane.createDialog("Error Message");
                 dialog.setAlwaysOnTop(true);
                 dialog.setVisible(true);
                 
           } else if(vp.equals("")){
               
               JOptionPane optionPane = new JOptionPane("Please select your Vice-President.!", JOptionPane.ERROR_MESSAGE);    
                 JDialog dialog = optionPane.createDialog("Error Message");
                 dialog.setAlwaysOnTop(true);
                 dialog.setVisible(true);
                 
           } else if(sec.equals("")){
               
                 JOptionPane optionPane = new JOptionPane("Please select your Secretary.!", JOptionPane.ERROR_MESSAGE);    
                 JDialog dialog = optionPane.createDialog("Error Message");
                 dialog.setAlwaysOnTop(true);
                 dialog.setVisible(true);
           }
           
           else {
               
               //President
               String query = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+pres+"'"; 
               st = con.createStatement();
               st.executeUpdate(query);
               
               //Vice-President
               String sqlquery = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+vp+"' "; 
               st = con.createStatement();
               st.executeUpdate(sqlquery);
               
                //Secretary
               String selectquery = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+sec+"' "; 
               st = con.createStatement();
               st.executeUpdate(selectquery);
               
               //Treasurer
               String treasurerquery = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+tres+"' "; 
               st = con.createStatement();
               st.executeUpdate(treasurerquery);
               
                //Auditor
               String auditorquery = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+auditor+"' "; 
               st = con.createStatement();
               st.executeUpdate(auditorquery);
               
               //PRO
               String proquery = "UPDATE voters SET number_of_votes = number_of_votes + 1 WHERE fullname ='"+pro+"' "; 
               st = con.createStatement();
               st.executeUpdate(proquery);
               
               
               String ssid = user_id.getText();
               
               //add into voted candidates
               String addsql = "INSERT INTO voted_candidates(Student_id,President,Vice_President,Secretary,Treasurer,Auditor,PRO)VALUES(?,?,?,?,?,?,?)";
            
               PreparedStatement ps = con.prepareStatement(addsql);
               ps.setString(1, ssid);
               ps.setString(2, pres);
               ps.setString(3, vp);
               ps.setString(4, sec);
               ps.setString(5, tres);
               ps.setString(6, auditor);
               ps.setString(7, pro);
               ps.execute();
               
               selected_president.setText("");
               selected_vice_pres.setText("");
               selected_sec.setText("");
               selected_tres.setText("");
               selected_audi.setText("");
               selected_pro.setText("");
               
               JOptionPane.showMessageDialog(null, "You are successfully voted.");
               
                new VoteWiselyForm(ssid).setVisible(true);
                new VoteWiselyForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                new VoteWiselyForm().setLocationRelativeTo(null);
                this.dispose();
                new VoteNowForm().setVisible(false);
           }
           
          
           
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_secretaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_secretaryActionPerformed
        // TODO add your handling code here:
        
        String sec = combo_secretary.getSelectedItem().toString();
        selected_sec.setText(sec);
    }//GEN-LAST:event_combo_secretaryActionPerformed

    private void combo_tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tresActionPerformed
        // TODO add your handling code here:
        
        String tres = combo_tres.getSelectedItem().toString();
        selected_tres.setText(tres);
    }//GEN-LAST:event_combo_tresActionPerformed

    private void combo_auditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_auditorActionPerformed

        String auditor = combo_auditor.getSelectedItem().toString();
        selected_audi.setText(auditor);
    }//GEN-LAST:event_combo_auditorActionPerformed

    private void combo_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_proActionPerformed

        String pro = combo_pro.getSelectedItem().toString();
        selected_pro.setText(pro);
    }//GEN-LAST:event_combo_proActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         String ssid = user_id.getText();
        
               new VoteWiselyForm(ssid).setVisible(true);
               new VoteWiselyForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                new VoteWiselyForm().setLocationRelativeTo(null);
                this.dispose();
                
                new VoteNowForm().setVisible(false);
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
            java.util.logging.Logger.getLogger(VoteNowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteNowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteNowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteNowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoteNowForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_auditor;
    private javax.swing.JComboBox<String> combo_president;
    private javax.swing.JComboBox<String> combo_pro;
    private javax.swing.JComboBox<String> combo_secretary;
    private javax.swing.JComboBox<String> combo_tres;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel selected_audi;
    private javax.swing.JLabel selected_president;
    private javax.swing.JLabel selected_pro;
    private javax.swing.JLabel selected_sec;
    private javax.swing.JLabel selected_tres;
    private javax.swing.JLabel selected_vice_pres;
    private javax.swing.JLabel user_id;
    // End of variables declaration//GEN-END:variables
}
