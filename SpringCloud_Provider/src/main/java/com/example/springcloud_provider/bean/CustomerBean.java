package com.example.springcloud_provider.bean;

public class CustomerBean {
    private String id;
    private String phoneNumber;
    private String username;
    private String address;
    private double totalConsumption;
    private String recentOrderTime;
    private String staffId;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public void setRecentOrderTime(String recentOrderTime){
        this.recentOrderTime = recentOrderTime;
    }
    public String getRecentOrderTime(){
        return recentOrderTime;
    }
}
