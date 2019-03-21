package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class VerificationCode implements Serializable{
    private Integer verificationcodeid;

    private String verificationcodestring;

    private String verificationcodetime;

    public Integer getVerificationcodeID() { return verificationcodeid; }

    public void setVerificationCodeID(Integer verificationcodeid) { this.verificationcodeid = verificationcodeid; }

    public String getVerificationCodeTime() { return verificationcodetime; }

    public void setVerificationCodeTime(String verificationcodetime) { this.verificationcodetime = verificationcodetime; }

    public String getVerificationCodeString() { return verificationcodestring; }

    public void setVerificationCodeString(String verificationcodestring) { this.verificationcodestring = verificationcodestring; }
}
