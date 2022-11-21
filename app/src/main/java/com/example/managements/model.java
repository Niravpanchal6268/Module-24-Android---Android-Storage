package com.example.managements;

public class model {
    public int sid;
    public String fname;
    public String lname;
    public String mobile;
    public String email;
    public String course;

    public model() {
    }

    public model(int sid, String fname, String lname, String mobile, String email, String course) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.course = course;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
