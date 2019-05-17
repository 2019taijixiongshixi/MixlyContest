package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Manager implements Serializable {
    private String managerid;

    private String password;

    public String getManagerID() {
        return managerid;
    }

    public void setManagerID(String managerid) { this.managerid = managerid; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}