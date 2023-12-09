package com.example.springcloud_provider.controller;

import com.example.springcloud_provider.bean.CustomerBean;
import com.example.springcloud_provider.bean.OrdersBean;
import com.example.springcloud_provider.service.CustomerService;
import com.example.springcloud_provider.serviceImpl.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Resource
    OrdersService ordersService;
    @RequestMapping(value = "/getcustomerinfo/{customerID}",method = RequestMethod.GET,produces = "application/json")
    public CustomerBean load(@PathVariable String customerID){
        return customerService.load(customerID);
    }
    @RequestMapping(value = "/getcustomerinfo/byorderID/{orderID}",method = RequestMethod.GET)
    public CustomerBean loadbyOrder(@PathVariable String orderID){
        OrdersBean ordersBean=ordersService.getById(orderID);
        String customerID=ordersBean.getConsumerId();
        System.out.println(customerID);
        return customerService.load(customerID);

    }
    @RequestMapping(value = "/employee/querycustomer",method = RequestMethod.POST,produces = "application/json")
    public List<CustomerBean> loadByNamePhone(String userName, String phoneNumber, String employeeID){
        return customerService.loadByNamePhone(userName,phoneNumber,employeeID);
    }
    @RequestMapping(value = "/modifycustomer",method = RequestMethod.POST,produces = "application/json")
    public String update(String id,String newName,String newSex,String newPhone,double newConsumption,String newAddress){

        return customerService.update(id,newPhone,newName,newSex,newConsumption,newAddress);
    }
    @RequestMapping(value = "/modifycustomer/delete",method = RequestMethod.POST,produces = "application/json")
    public String deleteOne(String id){
        return customerService.deleteOne(id);
    }
    @RequestMapping(value = "/employee/getcustomer",method = RequestMethod.POST,produces = "application/json")
    public List<CustomerBean> getByStaffId(String employeeID){

        return customerService.loadByEmployeeId(employeeID);
    }
    @RequestMapping(value = "/employee/addcustomer",method = RequestMethod.POST,produces = "application/json")
    public String addOne(String id,String username,String sex,String phoneNumber,String address,String employeeID){
        //输出所有参数
        System.out.println(id);
        System.out.println(username);
        System.out.println(sex);
        System.out.println(phoneNumber);
        System.out.println(address);
        System.out.println(employeeID);
        return customerService.addOne(id,username,phoneNumber,sex,address,employeeID);
    }
    @GetMapping(value = "/admin/customer/all",produces = "application/json")
    public List<CustomerBean>getAll(){
        return customerService.getAll();
    }
}
