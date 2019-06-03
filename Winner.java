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
public class Winner {

    private String lastname,firstname,position;
    private int no_of_votes;
    
    public Winner(){
        
    }

    public Winner(String lastname, String firstname, String position, int no_of_votes) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.position = position;
        this.no_of_votes = no_of_votes;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNo_of_votes() {
        return no_of_votes;
    }

    public void setNo_of_votes(int no_of_votes) {
        this.no_of_votes = no_of_votes;
    }
    
    
}

