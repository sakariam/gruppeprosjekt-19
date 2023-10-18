package org.example.Model;

public class Admin {
    private String A_name;
    private String A_email;
    private String tele_nr;


    public Admin(String a_name, String a_email, String tele_nr) {
        A_name = a_name;
        A_email = a_email;
        this.tele_nr = tele_nr;
    }

    // this will mark a guide if the many bad reviews and
    // it can also give good mark to if guide has has many good reviews

    public void markguide(){

    }

    public String getA_name() {
        return A_name;
    }

    public void setA_name(String a_name) {
        A_name = a_name;
    }

    public String getA_email() {
        return A_email;
    }

    public void setA_email(String a_email) {
        A_email = a_email;
    }

    public String getTele_nr() {
        return tele_nr;
    }

    public void setTele_nr(String tele_nr) {
        this.tele_nr = tele_nr;
    }
}
