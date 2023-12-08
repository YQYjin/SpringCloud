package com.example.springcloud_provider.serviceImpl;

import com.example.springcloud_provider.bean.StaffBean;
import com.example.springcloud_provider.mapper.StaffMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffService {
    @Resource
    StaffMapper staffMapper;
    public StaffBean getStaffInfo(String id){
        return staffMapper.getOneById(id);
    }
    public String changeStaff(String id,String username,String sex,String phoneNumber){
        int item=staffMapper.updateStaff(id,username,sex,phoneNumber);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String deleteStaff(String id){
        int item=staffMapper.deleteStaff(id);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<StaffBean>getAll(){
        return staffMapper.getAll();
    }
    public List<StaffBean>getByNamePhone(String username,String phoneNumber){
        return staffMapper.getByNamePhone(username,phoneNumber);
    }
    public String addOne(String addID,String username,String phoneNumber,String sex){
        int item=staffMapper.addOne(addID,username,phoneNumber,sex);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String updatePwd(String id,String password,String newPassword){
        int item=staffMapper.updatePwd(id,password,newPassword);
        System.out.println("mim"+item+password);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public StaffBean getByName(String username){
        return staffMapper.getByName(username);
    }
}
