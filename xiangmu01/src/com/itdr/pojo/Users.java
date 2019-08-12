package com.itdr.pojo;
//创建实体类，实体类中的名称和数据库中的名称相同。
public class Users {
    private Integer uid;
    private String uname;
    private String upwd;
    private String udh;
    //权限，如果为1 则是管理员，如果是0 则不是管理员
    private String uyhlx = "0" ;
    //如果被封号，就会变成1 ，如果没有被封号就是0
    private String uzc = "0";


    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", udh='" + udh + '\'' +
                ", uyhlx='" + uyhlx + '\'' +
                ", uzc='" + uzc + '\'' +
                '}';
    }

    public String getUyhlx() {
        return uyhlx;
    }

    public void setUyhlx(String uyhlx) {
        this.uyhlx= uyhlx;
//        if (uyhlx.equals("1")){
//            this.uyhlx ="普通管理员";
//        }else if (uyhlx.equals("2")){
//            this.uyhlx ="超级管理员";
//        }else {
//            this.uyhlx="普通用户";
//        }
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUdh() {
        return udh;
    }

    public void setUdh(String udh) {
        this.udh = udh;
    }

    public String getUzc() {
        return uzc;
    }

    public void setUzc(String uzc) {
        this.uzc = uzc;
    }
}
