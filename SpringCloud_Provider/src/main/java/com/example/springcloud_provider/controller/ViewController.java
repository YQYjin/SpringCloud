package com.example.springcloud_provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/admin/home/{ID}")
    public String adminHome(){
        return "/admin/admin-home";
    }
    @RequestMapping("/employee/customerDetail/{ID}")
    public String customerDetail(){
        return "/customer/customer-detail";
    }
    @RequestMapping("/employee/customerModify/{ID}")
    public String customerControl(){
        return "/customer/customer-control";
    }
    @RequestMapping("/employee/home/{ID}")
    public String employee(){
        return "/employee/employee-home";
    }
    @RequestMapping("/employee/employeeinfo/{emplyeeID}")
    public String employeeInfo(){
        return "/employee/employee-control";
    }
    @RequestMapping("admin/employeeinfo/{emplyeeID}")
    public String adminEmployeeInfo(){
        return "/employee/employee-control";
    }
    @RequestMapping("/admin/employeecontrol")
    public String employeeManagement(){
        return "/employee/employee-management";
    }
    @RequestMapping("/employee/orderDetail/{ID}")
    public String orderDetail(){
        return "/order/order-detail";
    }
    @RequestMapping("/employee/addorder/{employeeID}")
    public String addOrder(){
        return "/order/order-add";
    }
    @RequestMapping("/admin/productcontrol")
    public String productManagement(){
        return "/product/product-management";
    }
    @RequestMapping("/admin/productModify/{ID}")
    public String productModify(){
        return "/product/product-control";
    }
    @RequestMapping("/employee/addcustomer/{employID}")
    public String addCustomer(){return "/customer/customer-add";}

}
