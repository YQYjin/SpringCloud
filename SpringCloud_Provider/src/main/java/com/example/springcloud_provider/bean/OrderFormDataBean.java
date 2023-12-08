package com.example.springcloud_provider.bean;

import java.util.List;

public class OrderFormDataBean {
    private String customerName;
    private String orderRemark;
    private double totalPrice;
    private List<ProductRequestBean> orderContent;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductRequestBean> getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(List<ProductRequestBean> orderContent) {
        this.orderContent = orderContent;
    }
    // 省略构造函数和 getter/setter 方法
}
