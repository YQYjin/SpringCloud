package com.example.springcloud_user.contorller;//package com.example.springcloud_user.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @GetMapping("/admin/home/{ID}")
    public String adminHome(){
        return "/admin/admin-home";
    }
    @GetMapping("/employee/customerDetail/{ID}")
    public String customerDetail(){
        return "/customer/customer-detail";
    }
    @GetMapping("/employee/customerModify/{ID}")
    public String customerControl(){
        return "/customer/customer-control";
    }
    @GetMapping("/employee/home/{ID}")
    public String employee(){
        return "/employee/employee-home";
    }
    @GetMapping("/employee/employeeinfo/{emplyeeID}")
    public String employeeInfo(){
        return "/employee/employee-control";
    }
    @GetMapping("admin/employeeinfo/{emplyeeID}")
    public String adminEmployeeInfo(){
        return "/employee/employee-control";
    }
    @GetMapping("/admin/employeecontrol")
    public String employeeManagement(){
        return "/employee/employee-management";
    }
    @GetMapping("/employee/orderDetail/{ID}")
    public String orderDetail(){
        return "/order/order-detail";
    }
    @GetMapping("/employee/addorder/{employeeID}")
    public String addOrder(){
        return "/order/order-add";
    }
    @GetMapping("/admin/productcontrol")
    public String productManagement(){
        return "/product/product-management";
    }
    @GetMapping("/admin/productModify/{ID}")
    public String productModify(){
        return "/product/product-control";
    }
    @GetMapping("/employee/addcustomer/{employID}")
    public String addCustomer(){return "/customer/customer-add";}

}
