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
public class Voters {
    
     private int id;
    
    private String student_id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String course;
    private String year_level;
    private String position;
    private String no_of_votes;
    private String created_at;
    
    public Voters(){
        
    }

    public Voters(int id, String student_id, String lastname, String firstname, String middlename, String course, String year_level, String position, String no_of_votes, String created_at) {
        this.id = id;
        this.student_id = student_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.course = course;
        this.year_level = year_level;
        this.position = position;
        this.no_of_votes = no_of_votes;
        this.created_at = created_at;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear_level() {
        return year_level;
    }

    public void setYear_level(String year_level) {
        this.year_level = year_level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNo_of_votes() {
        return no_of_votes;
    }

    public void setNo_of_votes(String no_of_votes) {
        this.no_of_votes = no_of_votes;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    
    
}
