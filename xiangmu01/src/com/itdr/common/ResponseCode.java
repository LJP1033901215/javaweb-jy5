package com.itdr.common;
//创建一个类，使返回的数据都是相同的
public class ResponseCode<T> {
    private Integer status =null;
    private T data =null;//为了保证什么样的类型都可以返回，所有要设置泛型，保证什么样的都可以返回
    private String mag =null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    //成功的时候返回状态码和成功的数据就行了
    public  static <T> ResponseCode successRS(Integer status,T data){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        return rs;
    }
    public  static <T> ResponseCode defeatdRS(Integer status,String mag){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setMag(mag);
        return rs;
    }
    //失败的时候只要返回状态码和失败的信息就可以了

    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }
}
