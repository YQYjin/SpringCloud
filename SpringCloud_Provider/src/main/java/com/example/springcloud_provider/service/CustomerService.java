package com.example.springcloud_provider.service;

import com.example.springcloud_provider.bean.CustomerBean;

import java.util.List;

public interface CustomerService {
    CustomerBean load(String id);
    //CustomerBean loadByOrderID(String orderID);
    List<CustomerBean> loadByNamePhone(String name,String phoneNumber,String id);
    String update(String id,String phoneNumber,String username,String sex,double totalConsumption,String address);
    String deleteOne(String id);
    List<CustomerBean> loadByEmployeeId(String id);
    String addOne(String id,String username,String phoneNumber,String sex,String address,String staff_id);
    List<CustomerBean> getAll();
}
