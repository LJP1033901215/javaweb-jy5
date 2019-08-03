package com.itdr.pojo;

public class Poiduct {
    private Integer Pid;//ID
    private Integer PcategoruID;//分类的ID
    private String Pname;//产品名字
    private String Psubtitle;//产品的副标题
    private String Pmainlmage;//产品的图片
    private Integer Pstatus;//产品的上架是否
    private Double Pprice;//价格

    @Override
    public String toString() {
        return "Priduct{" +
                "Pid=" + Pid +
                ", PcategoruID=" + PcategoruID +
                ", Pname='" + Pname + '\'' +
                ", Psubtitle='" + Psubtitle + '\'' +
                ", Pmainlmage='" + Pmainlmage + '\'' +
                ", Pstatus=" + Pstatus +
                ", Pprice=" + Pprice +
                '}';
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public Integer getPcategoruID() {
        return PcategoruID;
    }

    public void setPcategoruID(Integer pcategoruID) {
        PcategoruID = pcategoruID;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPsubtitle() {
        return Psubtitle;
    }

    public void setPsubtitle(String psubtitle) {
        Psubtitle = psubtitle;
    }

    public String getPmainlmage() {
        return Pmainlmage;
    }

    public void setPmainlmage(String pmainlmage) {
        Pmainlmage = pmainlmage;
    }

    public Integer getPstatus() {
        return Pstatus;
    }

    public void setPstatus(Integer pstatus) {
        Pstatus = pstatus;
    }

    public Double getPprice() {
        return Pprice;
    }

    public void setPprice(Double pprice) {
        Pprice = pprice;
    }
}
