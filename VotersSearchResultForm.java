/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.government.election.system;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class VotersSearchResultForm extends javax.swing.JFrame {
    
     public Connection con;
     public Statement st;

    /**
     * Creates new form VotersSearchResultForm
     */
    public VotersSearchResultForm() {
        initComponents();
    }

    VotersSearchResultForm(String sid) {
         initComponents();
         
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_system?zeroDateTimeBehavior=convertToNull","root","");
            st = con.createStatement();
          
            
            
        }catch(Exception e){
            
              JOptionPane.showMessageDialog(null,"Database not Connected");
            
        }
         
         //studentId.setText(sid);
         
         findVoters(sid);
         
           label_student_id.setVisible(false);
        label_lastname.setVisible(false);
        label_firstname.setVisible(false);
        label_middlename.setVisible(false);
        label_course.setVisible(false);
        label_level.setVisible(false);
        
        student_id.setVisible(false);
        lastname.setVisible(false);
        firstname.setVisible(false);
        middlename.setVisible(false);
        course.setVisible(false);
        level.setVisible(false);
        
        combo_course.setVisible(false);
        combo_level.setVisible(false);
        
        button_update.setVisible(false);
        button_delete.setVisible(false);
         
         
    }
    
    
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
     * Search by sid
     * @param sid 
     */
    private void findVoters(String sid) {
        ArrayList<Voters>list = getSearchVOters(sid);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[7];
        for(int i = 0; i<list.size(); i++){
            
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getStudent_id();
            row[2] = list.get(i).getLastname();
            row[3] = list.get(i).getFirstname();
            row[4] = list.get(i).getMiddlename();
            row[5] = list.get(i).getCourse();
            row[6] = list.get(i).getYear_level();
            
            model.addRow(row);
        }
    }
    
     //Search Voters
     private ArrayList<Voters> getSearchVOters(String sid) {
        ArrayList<Voters>list = new ArrayList<Voters>();
        
     
        
        try{
            
            String sql = "SELECT * FROM voters WHERE student_id = '"+ sid +"'";
              
            
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                Voters candidates = new Voters();
                
                candidates.setId(rs.getInt("id"));
                candidates.setStudent_id(rs.getString("student_id"));
                candidates.setLastname(rs.getString("lastname"));
                candidates.setFirstname(rs.getString("firstname"));
                candidates.setMiddlename(rs.getString("middlename"));
                candidates.setCourse(rs.getString("course"));
                candidates.setYear_level(rs.getString("level"));
                list.add(candidates);
            } else {
                
                JOptionPane optionPane = new JOptionPane("Not Found!", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        student_id = new javax.swing.JTextField();
        label_student_id = new javax.swing.JLabel();
        label_lastname = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        label_firstname = new javax.swing.JLabel();
        label_middlename = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        label_course = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        course = new javax.swing.JLabel();
        label_level = new javax.swing.JLabel();
        combo_level = new javax.swing.JComboBox<>();
        level = new javax.swing.JLabel();
        button_update = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Voters Search Result");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "STUDENT ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "COURSE", "YEAR LEVEL"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_idKeyTyped(evt);
            }
        });

        label_student_id.setText("STUDENT ID:");

        label_lastname.setText("LASTNAME:");

        label_firstname.setText("FIRSTNAME:");

        label_middlename.setText("MIDDLENAME:");

        label_course.setText("COURSE:");

        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "BSIT", "BS-CS", "BS-COE", "BS-CRIM" }));
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });

        course.setText("COURSE");

        label_level.setText("YEAR-LEVEL:");

        combo_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "1st Year", "2nd Year", "3rd Year", "4th Year" }));
        combo_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_levelActionPerformed(evt);
            }
        });

        level.setText("YEAR-LEVEL");

        button_update.setBackground(new java.awt.Color(51, 51, 0));
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

        jMenuItem1.setText("<=Return");
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
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_student_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_delete)))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_student_id)
                            .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_lastname)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_firstname)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_middlename)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_course)
                            .addComponent(combo_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_level)
                            .addComponent(combo_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_update)
                            .addComponent(button_delete))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        // TODO add your handling code here:
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_student_idKeyTyped

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        // TODO add your handling code here:
        String co = combo_course.getSelectedItem().toString();
        course.setText(co);
    }//GEN-LAST:event_combo_courseActionPerformed

    private void combo_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_levelActionPerformed
        // TODO add your handling code here:

        String yr_lvl = combo_level.getSelectedItem().toString();
        level.setText(yr_lvl);
    }//GEN-LAST:event_combo_levelActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed

        try{
            String sid = student_id.getText();
            String lname = lastname.getText();
            String fname = firstname.getText();
            String mname = middlename.getText();
            String co = course.getText();
            String lvl = course.getText();

            if(sid.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Input Student ID!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if(lname.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Input Last Name!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if(fname.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Input First Name!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if(mname.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Input Middle Name!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if(co.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Select Course!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if(lvl.equals("")){

                JOptionPane optionPane = new JOptionPane("Please Select Year Level!", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error Message");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else{

                String query = "UPDATE `voters` SET `student_id`='"+student_id.getText()+"',`lastname`='"+lastname.getText()+"',`firstname`='"+firstname.getText()+"',`middlename`='"+middlename.getText()+"',`course`='"+course.getText()+"',`level`='"+level.getText()+"' WHERE student_id = '"+student_id.getText()+"'";
                executeSQlQuery(query,"ok");
                new ListOfVotersForm().setVisible(true);
                new ListOfVotersForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                new ListOfVotersForm().setLocationRelativeTo(null);
                this.dispose();

                new ListOfVotersForm().setVisible(false);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        String query = "DELETE FROM `voters` WHERE student_id = "+student_id.getText();
        executeSQlQuery(query, "Deleted");
        new ListOfVotersForm().setVisible(true);
        new ListOfVotersForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new ListOfVotersForm().setLocationRelativeTo(null);
        this.dispose();

        new ListOfVotersForm().setVisible(false);
    }//GEN-LAST:event_button_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
       
        
        student_id.setText(model.getValueAt(i,1).toString());
        lastname.setText(model.getValueAt(i,2).toString());
        firstname.setText(model.getValueAt(i,3).toString());
        middlename.setText(model.getValueAt(i,4).toString());
        course.setText(model.getValueAt(i,5).toString());
        level.setText(model.getValueAt(i,6).toString());
        
        
        label_student_id.setVisible(true);
        label_lastname.setVisible(true);
        label_firstname.setVisible(true);
        label_middlename.setVisible(true);
        label_course.setVisible(true);
        label_level.setVisible(true);
        
        student_id.setVisible(true);
        lastname.setVisible(true);
        firstname.setVisible(true);
        middlename.setVisible(true);
        course.setVisible(true);
        level.setVisible(true);
        
         combo_course.setVisible(true);
        combo_level.setVisible(true);
        
         button_update.setVisible(true);
        button_delete.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        new ListOfVotersForm().setVisible(true);
         new ListOfVotersForm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
         new ListOfVotersForm().setLocationRelativeTo(null);
         this.dispose();
                 
         new VotersSearchResultForm().setVisible(false);
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
            java.util.logging.Logger.getLogger(VotersSearchResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VotersSearchResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VotersSearchResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotersSearchResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotersSearchResultForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_level;
    private javax.swing.JLabel course;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel label_student_id;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel level;
    private javax.swing.JTextField middlename;
    private javax.swing.JTextField student_id;
    // End of variables declaration//GEN-END:variables

    
   
}
