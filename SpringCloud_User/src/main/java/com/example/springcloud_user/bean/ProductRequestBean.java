package com.example.springcloud_user.bean;

import java.util.List;
import java.util.Map;

public class ProductRequestBean {

    private Double totalPrice;
    private String customerName;
    private String orderRemark;

    private List<Map<String,String>> orderContent;

    public List<Map<String, String>> getOrderContent() {
        return orderContent;
    }
    public void setOrderContent(List<Map<String, String>> orderContent) {
        this.orderContent = orderContent;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String consumerName) {
        this.customerName = consumerName;
    }
    public String getOrderRemark() {
        return orderRemark;
    }
    public void setOrderRemark(String notes) {
        this.orderRemark = notes;
    }
}
