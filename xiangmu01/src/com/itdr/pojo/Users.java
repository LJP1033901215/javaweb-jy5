package com.itdr.pojo;
//创建实体类，实体类中的名称和数据库中的名称相同。
public class Users {
    private Integer uid;
    private String uname;
    private String upwd;
    private String udh;
    //权限，如果为1 则是管理员，如果是0 则不是管理员
    private Integer uyhlx = 0 ;
    //如果被封号，就会变成1 ，如果没有被封号就是0
    private Integer uzc = 0;
    @Override
    public String toString() {
        return "Users{" +
                "id=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", udh='" + udh + '\'' +
                ", uthlx=" + uyhlx +
                ", uzc=" + uzc +
                '}';
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer id) {
        this.uid = id;
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

    public Integer getUyhlx() {
        return uyhlx;
    }

    public void setUyhlx(Integer uyhlx) {
        this.uyhlx = uyhlx;
    }

    public Integer getUzc() {
        return uzc;
    }

    public void setUzc(Integer uzc) {
        this.uzc = uzc;
    }


}
