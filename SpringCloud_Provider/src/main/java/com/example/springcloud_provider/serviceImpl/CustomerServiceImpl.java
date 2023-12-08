package com.example.springcloud_provider.serviceImpl;

import com.example.springcloud_provider.bean.CustomerBean;
import com.example.springcloud_provider.mapper.CustomerMapper;
import com.example.springcloud_provider.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;
    public CustomerBean load(String id){
        return customerMapper.getById(id);
    }
    public List<CustomerBean> loadByNamePhone(String name,String phoneNumber,String id){
        return customerMapper.getByNamePhone(name,phoneNumber,id);
    }
    public String update(String id,String phoneNumber,String username,String sex,double totalConsumption,String address){
        int item=customerMapper.change(id,phoneNumber,username,sex,totalConsumption,address);
        if(item>0) return "success";
        else return "error";
    }
    public String deleteOne(String id){
        int item=customerMapper.deleteOne(id);
        if(item>0) return "success";
        else return "error";
    }
    public List<CustomerBean> loadByEmployeeId(String id){
        return customerMapper.getByEmployeeId(id);
    }
    public String addOne(String id,String username,String phoneNumber,String sex,String address,String staff_id){
        int item=customerMapper.addOne(id,username,phoneNumber,sex,address,staff_id);
        if(item>0) return "success";
        else return "error";
    }
    public List<CustomerBean>getAll(){
        return customerMapper.getAll();
    }
}
