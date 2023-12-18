package com.example.springcloud_provider.controller;

import com.example.springcloud_provider.bean.AdministratorBean;
import com.example.springcloud_provider.bean.CustomerBean;
import com.example.springcloud_provider.serviceImpl.AdministratorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AdminController {
    @Resource
    AdministratorService administratorService;
    @RequestMapping(value = "/admin/getpwd",method = RequestMethod.POST,produces = "application/json")
    public AdministratorBean getById(String username){
        AdministratorBean rst=administratorService.getByName(username);
        return rst;
    }
}
