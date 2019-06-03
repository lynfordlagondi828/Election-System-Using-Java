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
public class ListOfCandidatesForm extends javax.swing.JFrame {
    
    public Connection con;
    public Statement st;

    /**
     * Creates new form ListOfCandidatesForm
     */
    public ListOfCandidatesForm() {
        initComponents();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
            
            
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
         
         
        show_list_of_candidates();
         
         
         /**
          * Visibility of labels
          */
         label_student_id.setVisible(false);
         label_lastname.setVisible(false);
         label_firstname.setVisible(false);
         label_middlename.setVisible(false);
         label_course.setVisible(false);
         label_level.setVisible(false);
         label_position.setVisible(false);
         
         combo_course.setVisible(false);
         combo_level.setVisible(false);
         combo_position.setVisible(false);
         
         button_update.setVisible(false);
         button_delete.setVisible(false);
         
         /**
          * text field visibility
          */
         studentId.setVisible(false);
         lastname.setVisible(false);
         firstname.setVisible(false);
         middlename.setVisible(false);
         course.setVisible(false);
         level.setVisible(false);
         position.setVisible(false);
                
         
         
    }
    
    
    
    /**
     * get all voters from the list
     */
    public ArrayList<Voters> getCandidateList(){
        
        ArrayList<Voters>list = new ArrayList<Voters>();
        
        try{
            
           
            
            String query = "SELECT * FROM voters WHERE status = 'candidate'";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Voters candidates = new Voters();
                
                candidates.setId(rs.getInt("id"));
                candidates.setStudent_id(rs.getString("student_id"));
                candidates.setLastname(rs.getString("lastname"));
                candidates.setFirstname(rs.getString("firstname"));
                candidates.setMiddlename(rs.getString("middlename"));
                candidates.setCourse(rs.getString("course"));
                candidates.setYear_level(rs.getString("level"));
                candidates.setPosition(rs.getString("position"));
                candidates.setNo_of_votes(rs.getString("number_of_votes"));
                candidates.setCreated_at(rs.getString("created_at"));
                list.add(candidates);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void search_result_list_of_candidates(String sid){
        
        ArrayList<Voters>list = getCandidateList();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[9];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getStudent_id();
            row[2] = list.get(i).getLastname();
            row[3] = list.get(i).getFirstname();
            row[4] = list.get(i).getMiddlename();
            row[5] = list.get(i).getCourse();
            row[6] = list.get(i).getYear_level();
            row[7] = list.get(i).getPosition();
            row[8] = list.get(i).getCreated_at();
            
            model.addRow(row);
        }
    }
    
    /**
     * show voters on table
     */
    public void show_list_of_candidates(){
        
        ArrayList<Voters>list = getCandidateList();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[9];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getStudent_id();
            row[2] = list.get(i).getLastname();
            row[3] = list.get(i).getFirstname();
            row[4] = list.get(i).getMiddlename();
            row[5] = list.get(i).getCourse();
            row[6] = list.get(i).getYear_level();
            row[7] = list.get(i).getPosition();
            row[8] = list.get(i).getCreated_at();
            
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
        student_id = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        label_student_id = new javax.swing.JLabel();
        studentId = new javax.swing.JTextField();
        label_lastname = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        label_firstname = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        label_middlename = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        label_course = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        course = new javax.swing.JLabel();
        label_level = new javax.swing.JLabel();
        combo_level = new javax.swing.JComboBox<>();
        level = new javax.swing.JLabel();
        label_position = new javax.swing.JLabel();
        combo_position = new javax.swing.JComboBox<>();
        position = new javax.swing.JLabel();
        button_update = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("List of Candidates");

        jLabel2.setText("Input Student ID:");

        student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_idKeyTyped(evt);
            }
        });

        button_search.setText("Search");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "STUDENT ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "COURSE", "YEAR LEVEL", "POSITION"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+ ADD CANDIDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label_student_id.setText("STUDENT ID");

        studentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentIdKeyTyped(evt);
            }
        });

        label_lastname.setText("LASTNAME:");

        label_firstname.setText("FIRSTNAME");

        label_middlename.setText("MIDDLENAME:");

        label_course.setText("COURSE:");

        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "BSIT", "BS-CS", "BS-COE", "BS-CRIM" }));
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });

        course.setText("COURSE");

        label_level.setText("YEAR LEVEL:");

        combo_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "1st Year", "2nd Year", "3rd Year", "4th Year" }));
        combo_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_levelActionPerformed(evt);
            }
        });

        level.setText("YEAR-LEVEL");

        label_position.setText("POSITION:");

        combo_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "President", "Vice-President", "Secretary", "Treasurer", "Auditor", "PRO" }));
        combo_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_positionActionPerformed(evt);
            }
        });

        position.setText("POSITION");

        button_update.setBackground(new java.awt.Color(255, 153, 0));
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Update");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 0, 0));
        button_delete.setForeground(new java.awt.Color(255, 255, 255));
        button_delete.setText("Delete");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_search))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_delete))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_student_id)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_lastname)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lastname))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_firstname)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(firstname))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_middlename)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(middlename))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_course)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combo_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(course))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_level)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combo_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(level))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_position)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combo_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(position))))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_student_id)
                            .addComponent(studentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_lastname)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_firstname)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_middlename)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_course)
                            .addComponent(combo_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_level)
                            .addComponent(combo_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_position)
                            .addComponent(combo_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_update)
                    .addComponent(button_delete))
                .addGap(0, 37, Short.MAX_VALUE))
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
                    
         new ListOfVotersForm().setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        // TODO add your handling code here:
        
        String c = combo_course.getSelectedItem().toString();
        course.setText(c);
    }//GEN-LAST:event_combo_courseActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        // TODO add your handling code here:
       String search = student_id.getText();
       
       if(search.equals("")){
            JOptionPane optionPane = new JOptionPane("Please input Student Id", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

       }else {
             new CandidateSearchResultForm(search).setVisible(true);
         new CandidateSearchResultForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         new CandidateSearchResultForm().setLocationRelativeTo(null);
         this.dispose();
                    
         new ListOfCandidatesForm().setVisible(false);
       }
       
     
       
       
       
    }//GEN-LAST:event_button_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        int i = jTable1.getSelectedRow();
         TableModel model = jTable1.getModel();
       
         studentId.setText(model.getValueAt(i,1).toString());
         lastname.setText(model.getValueAt(i,2).toString());
         firstname.setText(model.getValueAt(i,3).toString());
         middlename.setText(model.getValueAt(i,4).toString());
         course.setText(model.getValueAt(i,5).toString());
         level.setText(model.getValueAt(i,6).toString());
         position.setText(model.getValueAt(i, 7).toString());
         
         
         /**
          * Visibility of labels
          */
         label_student_id.setVisible(true);
         label_lastname.setVisible(true);
         label_firstname.setVisible(true);
         label_middlename.setVisible(true);
         label_course.setVisible(true);
         label_level.setVisible(true);
         label_position.setVisible(true);
         
         combo_course.setVisible(true);
         combo_level.setVisible(true);
         combo_position.setVisible(true);
         
         button_update.setVisible(true);
         button_delete.setVisible(true);
         
         /**
          * text field visibility
          */
         studentId.setVisible(true);
         lastname.setVisible(true);
         firstname.setVisible(true);
         middlename.setVisible(true);
         course.setVisible(true);
         level.setVisible(true);
         position.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

     
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
    
    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed

        try{
            
            String query = "UPDATE `voters` SET `student_id`='"+studentId.getText()+"',`lastname`='"+lastname.getText()+"',`firstname`='"+firstname.getText()+"',`middlename`='"+middlename.getText()+"',`course`='"+course.getText()+"',`level`='"+level.getText()+"',`position`='"+position.getText()+"' WHERE student_id = '"+studentId.getText()+"'";
            executeSQlQuery(query,"ok");
                    // TODO add your handling code here:
        
         new ListOfCandidatesForm().setVisible(true);
         new ListOfCandidatesForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
         new ListOfCandidatesForm().setLocationRelativeTo(null);
         this.dispose();
                 
         new ListOfCandidatesForm().setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void combo_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_levelActionPerformed
        // TODO add your handling code here:
        String l = combo_level.getSelectedItem().toString();
        level.setText(l);
    }//GEN-LAST:event_combo_levelActionPerformed

    private void combo_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_positionActionPerformed

         String pos = combo_position.getSelectedItem().toString();
         position.setText(pos);
    }//GEN-LAST:event_combo_positionActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
          String query = "DELETE FROM `voters` WHERE student_id = "+studentId.getText();
         executeSQlQuery(query, "Deleted");    
         new ListOfCandidatesForm().setVisible(true);
         new ListOfCandidatesForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
         new ListOfCandidatesForm().setLocationRelativeTo(null);
         this.dispose();
                 
         new ListOfCandidatesForm().setVisible(false);
    }//GEN-LAST:event_button_deleteActionPerformed

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        // TODO add your handling code here:
                // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_student_idKeyTyped

    private void studentIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIdKeyTyped
        // TODO add your handling code here:
                // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_studentIdKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        
         new FilingOfCandidacyForm().setVisible(true);
         new FilingOfCandidacyForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
         new FilingOfCandidacyForm().setLocationRelativeTo(null);
         this.dispose();
                 
         new ListOfCandidatesForm().setVisible(false);
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
            java.util.logging.Logger.getLogger(ListOfCandidatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfCandidatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfCandidatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfCandidatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfCandidatesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_search;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_level;
    private javax.swing.JComboBox<String> combo_position;
    private javax.swing.JLabel course;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_course;
    private javax.swing.JLabel label_firstname;
    private javax.swing.JLabel label_lastname;
    private javax.swing.JLabel label_level;
    private javax.swing.JLabel label_middlename;
    private javax.swing.JLabel label_position;
    private javax.swing.JLabel label_student_id;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel level;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel position;
    private javax.swing.JTextField studentId;
    private javax.swing.JTextField student_id;
    // End of variables declaration//GEN-END:variables
}
