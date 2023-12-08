package com.example.springcloud_provider.mapper;

import com.example.springcloud_provider.bean.CustomerBean;

import java.util.List;

public interface CustomerMapper {
    CustomerBean getById(String id);
    List<CustomerBean> getByNamePhone(String name,String phoneNumber,String id);
    int change(String id,String phoneNumber,String username,String sex,double totalConsumption,String address);
    int deleteOne(String id);
    List<CustomerBean> getByEmployeeId(String id);
    int addOne(String id,String username,String phoneNumber,String sex,String address,String staff_id);
    List<CustomerBean> getAll();
    CustomerBean getByName(String username);
}
