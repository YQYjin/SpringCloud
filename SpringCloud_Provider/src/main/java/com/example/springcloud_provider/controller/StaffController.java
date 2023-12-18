package com.example.springcloud_provider.controller;

import com.example.springcloud_provider.bean.AdministratorBean;
import com.example.springcloud_provider.bean.StaffBean;
import com.example.springcloud_provider.serviceImpl.AdministratorService;
import com.example.springcloud_provider.serviceImpl.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StaffController {
    @Resource
    StaffService staffService;
    @RequestMapping(value = "/getemployeeinfo/{id}",method = RequestMethod.GET,produces = "application/json")
    public StaffBean getStaffInfo(@PathVariable String id){
        return staffService.getStaffInfo(id);
    }
    @RequestMapping(value = "/modifyemployee",method = RequestMethod.POST,produces = "application/json")
    public String changeStaff(@RequestParam String id, @RequestParam String newName, @RequestParam String newSex, @RequestParam String newPhone){
        return staffService.changeStaff(id,newName,newSex,newPhone);
    }
    @RequestMapping(value = "/modifyemployee/delete",method = RequestMethod.POST,produces = "application/json")
    public String deleteStaff(String id){
        return staffService.deleteStaff(id);
    }
    @RequestMapping(value = "/admin/allemployee",method = RequestMethod.GET,produces = "application/json")
    public List<StaffBean> loadAll(){
        return staffService.getAll();
    }
    @RequestMapping(value = "/admin/queryemployee",method = RequestMethod.POST,produces = "application/json")
    public List<StaffBean> loadByNamePhone(String username,String phoneNumber){
        return staffService.getByNamePhone(username,phoneNumber);
    }
    @RequestMapping(value = "/admin/addemployee",method = RequestMethod.POST,produces = "application/json")
    public String addOne(String addID,String addName,String addPhone,String addSex){
        System.out.println("ID:"+addID+"name"+addName+"phone"+addPhone+"sex"+addSex);

        return staffService.addOne(addID,addName,addPhone,addSex);
    }
    @RequestMapping(value = "/modifyemployee/password",method = RequestMethod.POST,produces = "application/json")
    public String updatePwd(String id,String nowPassword,String newPassword){
        return staffService.updatePwd(id,nowPassword,newPassword);
    }
    @RequestMapping(value = "/employee/getpwd",method = RequestMethod.POST,produces = "application/json")
    public StaffBean getByName(String username){
        StaffBean rst=staffService.getByName(username);
        return rst;
    }
}
