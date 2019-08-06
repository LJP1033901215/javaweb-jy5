package com.itdr.pojo;

public class Order {
    String orderNo;
    Double payment;
    Integer paymentType;
    String paymentTypeDesc;
    Integer postage;
    Integer status;
    String statusDesc;
    String paymentTime;
    String sendTime;
    String endTime;
    String cliseTime;
    String createTime;
    String orderItemVoList;
    Integer shippingId;
    Integer shippingVo;

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", paymentTypeDesc='" + paymentTypeDesc + '\'' +
                ", postage=" + postage +
                ", status=" + status +
                ", statusDesc='" + statusDesc + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cliseTime='" + cliseTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", orderItemVoList='" + orderItemVoList + '\'' +
                ", shippingId=" + shippingId +
                ", shippingVo=" + shippingVo +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCliseTime() {
        return cliseTime;
    }

    public void setCliseTime(String cliseTime) {
        this.cliseTime = cliseTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(String orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public Integer getShippingVo() {
        return shippingVo;
    }

    public void setShippingVo(Integer shippingVo) {
        this.shippingVo = shippingVo;
    }
}
