package com.example.sam.atelierfirebase;

/**
 * Created by sam on 18/10/17.
 */

public class UserModels {


    private String prenom;
    private String mdp;
    private String score;

    public UserModels() {

    }

    public UserModels(String prenom, String mdp, String score) {
        this.prenom = prenom;
        this.mdp = mdp;
        this.score = score;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
