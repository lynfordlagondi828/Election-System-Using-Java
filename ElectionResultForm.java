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
public class ElectionResultForm extends javax.swing.JFrame {

      
    public Connection con;
    public Statement st;
    /**
     * Creates new form ElectionResult
     */
    public ElectionResultForm() {
        initComponents();
             try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
            
            
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
             
             show_election_result_for_president();
             show_election_result_for_vice_president();
             show_election_result_for_secretary();
             show_election_result_for_treasurer();
             show_election_result_for_auditor();
             show_election_result_for_pro();
    }
    
    //get presidential election Result
    public ArrayList<ElectionResult> getElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'President' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void show_election_result_for_president(){
        
        ArrayList<ElectionResult>list = getElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
        }
    }
    
    
     //get vice presidential election Result
    public ArrayList<ElectionResult> getVicePresElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'Vice-President' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
     public void show_election_result_for_vice_president(){
        
        ArrayList<ElectionResult>list = getVicePresElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
        }
    }
     
     
      //get vice SECRETARY election Result
    public ArrayList<ElectionResult> getSecretaryElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'Secretary' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
     public void show_election_result_for_secretary(){
        
        ArrayList<ElectionResult>list = getSecretaryElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
        }
    }
     
     //GET TREASURER
     public ArrayList<ElectionResult> getTreasurerElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'Treasurer' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
     
     public void show_election_result_for_treasurer(){
        
        ArrayList<ElectionResult>list = getTreasurerElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
        }
    }
    
     //GET AUDITOR
     public ArrayList<ElectionResult> getAuditorElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'Auditor' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
     
     public void show_election_result_for_auditor(){
        
        ArrayList<ElectionResult>list = getAuditorElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
        }
    }
     
     //get pro
     public ArrayList<ElectionResult> getPROElectionResult(){
        
        ArrayList<ElectionResult>list = new ArrayList<ElectionResult>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE position = 'PRO' ORDER BY number_of_votes DESC";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                ElectionResult candidates = new ElectionResult();
                
               candidates.setLastname(rs.getString("lastname"));
               candidates.setFirstname(rs.getString("firstname"));
               candidates.setNo_of_votes(rs.getInt("number_of_votes"));
                
                
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
     
      public void show_election_result_for_pro(){
        
        ArrayList<ElectionResult>list = getPROElectionResult();
        
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getLastname();
            row[1] = list.get(i).getFirstname();
            row[2] = list.get(i).getNo_of_votes();
            model.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Election Result");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("PRESIDENT");

        jTable1.setBackground(new java.awt.Color(153, 0, 153));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Vice-President");

        jTable2.setBackground(new java.awt.Color(0, 51, 51));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setBackground(new java.awt.Color(204, 0, 0));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Secretary");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("TREASURER");

        jTable5.setBackground(new java.awt.Color(0, 153, 153));
        jTable5.setForeground(new java.awt.Color(255, 255, 255));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("AUDITOR");

        jTable6.setBackground(new java.awt.Color(153, 51, 0));
        jTable6.setForeground(new java.awt.Color(255, 255, 255));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("PRO");

        jTable7.setBackground(new java.awt.Color(0, 0, 153));
        jTable7.setForeground(new java.awt.Color(255, 255, 255));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LASTNAME", "FIRSTNAME", "NUMBER OF VOTES"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Winner");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(208, 208, 208))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new MainForm().setVisible(true);
         new MainForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         new MainForm().setLocationRelativeTo(null);
         this.dispose();
                    
         new ElectionResultForm().setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new WinnerForm().setVisible(true);
         new WinnerForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
         new WinnerForm().setLocationRelativeTo(null);
         this.dispose();
                 
         new ElectionResultForm().setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ElectionResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElectionResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElectionResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElectionResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectionResultForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables
}
