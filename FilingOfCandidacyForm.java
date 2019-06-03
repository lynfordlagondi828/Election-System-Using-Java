/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.government.election.system;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lynford
 */
public class FilingOfCandidacyForm extends javax.swing.JFrame {

    public Connection con;
    public Statement st;
    /**
     * Creates new form candidateForm
     */
    public FilingOfCandidacyForm() {
        initComponents();
        jTable2.setVisible(false);
        label_voters.setVisible(false);
        
        
        /**
         * label visibility
         */
        
        label_student_id.setVisible(false);
        label_lastname.setVisible(false);
        label_firstname.setVisible(false);
        label_middlename.setVisible(false);
        label_course.setVisible(false);
        label_level.setVisible(false);
        
       text_student_id.setVisible(false);
       text_lastname.setVisible(false);
       text_firstname.setVisible(false);
       text_middlename.setVisible(false);
       text_mcourse.setVisible(false);
       text_level.setVisible(false);
       
       combo_position.setVisible(false);
       
       button_add_as_candidate.setVisible(false);
       label_select_position.setVisible(false);
       
     
       
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
            
            
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
        
        
        
    }

 
    
     /**
     * get all voters from the list
     */
    public ArrayList<Voters> getVOtersList(String sid){
        
        ArrayList<Voters>list = new ArrayList<Voters>();
        
        try{
            
            String query = "SELECT * FROM voters WHERE student_id = ?";
            PreparedStatement ps_stmt = con.prepareStatement(query);
            ps_stmt.setString(1, sid);
            ResultSet rs = ps_stmt.executeQuery();
            
            while(rs.next()){
                Voters voters = new Voters();
                
                voters.setId(rs.getInt("id"));
                voters.setStudent_id(rs.getString("student_id"));
                voters.setLastname(rs.getString("lastname"));
                voters.setFirstname(rs.getString("firstname"));
                voters.setMiddlename(rs.getString("middlename"));
                voters.setCourse(rs.getString("course"));
                voters.setYear_level(rs.getString("level"));
                voters.setCreated_at(rs.getString("created_at"));
                list.add(voters);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * show voters on table
     */
    public void show_list_of_voters(String sid){
        
        ArrayList<Voters>list = getVOtersList(sid);
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[8];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getStudent_id();
            row[2] = list.get(i).getLastname();
            row[3] = list.get(i).getFirstname();
            row[4] = list.get(i).getMiddlename();
            row[5] = list.get(i).getCourse();
            row[6] = list.get(i).getYear_level();
            row[7] = list.get(i).getCreated_at();
            
            model.addRow(row);
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

        jLabel2 = new javax.swing.JLabel();
        StudentId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        label_voters = new javax.swing.JLabel();
        label_student_id = new javax.swing.JLabel();
        label_lastname = new javax.swing.JLabel();
        label_firstname = new javax.swing.JLabel();
        label_middlename = new javax.swing.JLabel();
        label_course = new javax.swing.JLabel();
        label_level = new javax.swing.JLabel();
        button_add_as_candidate = new javax.swing.JButton();
        text_course = new javax.swing.JLabel();
        text_year_level = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text_student_id = new javax.swing.JLabel();
        text_lastname = new javax.swing.JLabel();
        text_firstname = new javax.swing.JLabel();
        text_middlename = new javax.swing.JLabel();
        text_mcourse = new javax.swing.JLabel();
        text_level = new javax.swing.JLabel();
        combo_position = new javax.swing.JComboBox<>();
        text_position = new javax.swing.JLabel();
        label_select_position = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Input Student Id");

        StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIdActionPerformed(evt);
            }
        });
        StudentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StudentIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StudentIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StudentIdKeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "STUDENT ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "COURSE", "LEVEL", "CREATED AT"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label_voters.setText("List of Registered Voters");

        label_student_id.setText("Student ID: ");

        label_lastname.setText("Last Name:");

        label_firstname.setText("First Name:");

        label_middlename.setText("Middle Name:");

        label_course.setText("Course:");

        label_level.setText("Year Level:");

        button_add_as_candidate.setText("Add as Candidate");
        button_add_as_candidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_as_candidateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Filing of Candidacy");

        text_student_id.setText("sid");

        text_lastname.setText("lname");

        text_firstname.setText("fname");

        text_middlename.setText("mname");

        text_mcourse.setText("course");

        text_level.setText("level");

        combo_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "President", "Vice-President", "Secretary", "Treasurer", "Auditor", "PRO" }));
        combo_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_positionActionPerformed(evt);
            }
        });

        label_select_position.setText("Select Position");

        jMenu1.setText("Return");

        jMenuItem1.setText("admin panel");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(397, 397, 397))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_position, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_position, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(162, 162, 162))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_select_position)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(label_voters))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(642, 642, 642)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(text_course, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button_add_as_candidate)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(text_year_level, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label_lastname)
                                            .addComponent(label_firstname)
                                            .addComponent(label_middlename))
                                        .addComponent(label_level)
                                        .addComponent(label_course))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(text_level, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(text_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text_middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text_mcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(701, 701, 701)
                                    .addComponent(label_student_id)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(text_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGap(132, 132, 132))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(2, 2, 2)
                .addComponent(label_voters)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_student_id)
                            .addComponent(text_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_lastname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_firstname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_middlename))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_course)
                            .addComponent(text_mcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_level)
                            .addComponent(text_level, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_select_position)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_position, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(text_course, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_add_as_candidate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(text_year_level)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         new MainForm().setVisible(true);
         new MainForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         new MainForm().setLocationRelativeTo(null);
         this.dispose();
                    
         new ListOfVotersForm().setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void StudentIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentIdKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_StudentIdKeyTyped

    private void StudentIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentIdKeyPressed

       
    }//GEN-LAST:event_StudentIdKeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

         int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();

         text_student_id.setText(model.getValueAt(i,1).toString());
         text_lastname.setText(model.getValueAt(i, 2).toString());
         text_firstname.setText(model.getValueAt(i, 3).toString());
         text_middlename.setText(model.getValueAt(i, 4).toString());
         text_mcourse.setText(model.getValueAt(i, 5).toString());
         text_level.setText(model.getValueAt(i, 6).toString());
         
         
           label_student_id.setVisible(true);
        label_lastname.setVisible(true);
        label_firstname.setVisible(true);
        label_middlename.setVisible(true);
        label_course.setVisible(true);
        label_level.setVisible(true);
        
       text_student_id.setVisible(true);
       text_lastname.setVisible(true);
       text_firstname.setVisible(true);
       text_middlename.setVisible(true);
       text_mcourse.setVisible(true);
       text_level.setVisible(true);
       
       combo_position.setVisible(true);
       
        button_add_as_candidate.setVisible(true);
     
        
       label_select_position.setVisible(true);

    }//GEN-LAST:event_jTable2MouseClicked

    private void StudentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentIdKeyReleased
       
    }//GEN-LAST:event_StudentIdKeyReleased

    private void StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIdActionPerformed
       
    }//GEN-LAST:event_StudentIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

           
            
            try{
                
                String sid = StudentId.getText();
                
                if(sid.equals("")){
                    
                    JOptionPane.showMessageDialog(null,"Please Input Student Id.");
                } else {
                    
                    String query = "SELECT * FROM voters WHERE student_id = ?";
                    PreparedStatement ps_stmt = con.prepareStatement(query);
                    ps_stmt.setString(1, sid);
                    ResultSet rs = ps_stmt.executeQuery();
            
                    if(rs.next()){
                
                        show_list_of_voters(sid);
                        jTable2.setVisible(true);
                        label_voters.setVisible(true);
                
                    }else {
                        
                        
                         
                        
                        JOptionPane optionPane = new JOptionPane(sid + " is not registered as a voter.", JOptionPane.ERROR_MESSAGE);    
                        JDialog dialog = optionPane.createDialog("Message");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                        
                        
                
                   
                     label_voters.setVisible(false);
                    }
                }
                
                
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
                  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_positionActionPerformed
        // TODO add your handling code here:
        
        String selected_position = combo_position.getSelectedItem().toString();
        text_position.setText(selected_position);
    }//GEN-LAST:event_combo_positionActionPerformed

    private void button_add_as_candidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_as_candidateActionPerformed
        // TODO add your handling code here:
        
        try {
            
            String sid = text_student_id.getText();
            String lname = text_lastname.getText();
            String fname = text_firstname.getText();
            String mname = text_middlename.getText();
            String course = text_mcourse.getText();
            String level = text_level.getText();
            String pos = text_position.getText();
            int number_of_votes = 0;
            String status = "candidate";
        
            if(pos.equals("")){

                JOptionPane optionPane = new JOptionPane("Please select position!", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }
            else {

                 String mquery = "SELECT * FROM voters WHERE student_id = ? AND status = 'candidate'";
                 PreparedStatement ps_stmt = con.prepareStatement(mquery);
                 ps_stmt.setString(1, sid);
                 ResultSet rs = ps_stmt.executeQuery();
                 
                 if(rs.next()){
                      JOptionPane optionPane = new JOptionPane(lname + ", " + fname + " already in the candidate list.", JOptionPane.ERROR_MESSAGE);    
                      JDialog dialog = optionPane.createDialog("Error Message");
                      dialog.setAlwaysOnTop(true);
                      dialog.setVisible(true);
                      
                 } else {
                     
                         String query = "UPDATE `voters` SET `student_id`='"+text_student_id.getText()+"',`lastname`='"+text_lastname.getText()+"',`firstname`='"+text_firstname.getText()+"',`middlename`='"+text_middlename.getText()+"',`course`='"+text_mcourse.getText()+"',`level`='"+text_level.getText()+"',`position`='"+text_position.getText()+"',`number_of_votes`='"+number_of_votes+"',`status`='"+status+"' WHERE student_id = '"+text_student_id.getText()+"'";
                        executeSQlQuery(query,"ok");
                
                        
                        JOptionPane.showMessageDialog(null, fname + " " + " " + lname + " successfully added to official candidates.");
                                // TODO add your handling code here:
        
                        new ListOfCandidatesForm().setVisible(true);
                        new ListOfCandidatesForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        new ListOfCandidatesForm().setLocationRelativeTo(null);
                        this.dispose();

                        new FilingOfCandidacyForm().setVisible(false);
                 }
                

                    
                
                     
            }

        }catch(Exception e){
            
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_button_add_as_candidateActionPerformed

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
            java.util.logging.Logger.getLogger(FilingOfCandidacyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilingOfCandidacyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilingOfCandidacyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilingOfCandidacyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilingOfCandidacyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField StudentId;
    private javax.swing.JButton button_add_as_candidate;
    private javax.swing.JComboBox<String> combo_position;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel label_course;
    private javax.swing.JLabel label_firstname;
    private javax.swing.JLabel label_lastname;
    private javax.swing.JLabel label_level;
    private javax.swing.JLabel label_middlename;
    private javax.swing.JLabel label_select_position;
    private javax.swing.JLabel label_student_id;
    private javax.swing.JLabel label_voters;
    private javax.swing.JLabel text_course;
    private javax.swing.JLabel text_firstname;
    private javax.swing.JLabel text_lastname;
    private javax.swing.JLabel text_level;
    private javax.swing.JLabel text_mcourse;
    private javax.swing.JLabel text_middlename;
    private javax.swing.JLabel text_position;
    private javax.swing.JLabel text_student_id;
    private javax.swing.JLabel text_year_level;
    // End of variables declaration//GEN-END:variables
}
