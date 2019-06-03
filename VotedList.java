/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.government.election.system;

/**
 *
 * @author Lynford
 */
public class VotedList {
    
    
    private int id;
    private String student_id,president,vice_president,secretary,treasurer,auditor,pro,date_voted;
    
    public VotedList(){
        
    }

    public VotedList(int id, String student_id, String president, String vice_president, String secretary, String treasurer, String auditor, String pro, String date_voted) {
        this.id = id;
        this.student_id = student_id;
        this.president = president;
        this.vice_president = vice_president;
        this.secretary = secretary;
        this.treasurer = treasurer;
        this.auditor = auditor;
        this.pro = pro;
        this.date_voted = date_voted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVice_president() {
        return vice_president;
    }

    public void setVice_president(String vice_president) {
        this.vice_president = vice_president;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public String getTreasurer() {
        return treasurer;
    }

    public void setTreasurer(String treasurer) {
        this.treasurer = treasurer;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getDate_voted() {
        return date_voted;
    }

    public void setDate_voted(String date_voted) {
        this.date_voted = date_voted;
    }
    
    
}
