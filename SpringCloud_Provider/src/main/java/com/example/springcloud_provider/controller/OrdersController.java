package com.example.springcloud_provider.controller;

import com.example.springcloud_provider.bean.OrdersBean;
import com.example.springcloud_provider.bean.ProductRequestBean;
import com.example.springcloud_provider.serviceImpl.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {
    @Resource
    OrdersService ordersService;
    @RequestMapping(value = "/getorderinfo/{orderID}",method = RequestMethod.GET)
    public OrdersBean loadById(@PathVariable String orderID){
        return ordersService.getById(orderID);
    }
    @RequestMapping(value = "/employee/order/bycustomerid/{customerID}",method = RequestMethod.GET)
    public List<OrdersBean> loadByCustomerId(@PathVariable String customerID){
        return ordersService.getAllByCustomerId(customerID);
    }
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public String addOneOrder( @RequestBody ProductRequestBean orderData){
        //输出orderContent
        System.out.println(orderData.getCustomerName());
        System.out.println(orderData.getOrderRemark());
        List<Map<String,String>> orderContent=orderData.getOrderContent();
        for (Map<String,String> order : orderContent) {
            System.out.println(order.get("productId"));
            System.out.println(order.get("quantity"));
        }
        double totalPrice=orderData.getTotalPrice();
        String customerName=orderData.getCustomerName();
        String orderRemark=orderData.getOrderRemark();
        return ordersService.addOrder(totalPrice,customerName,orderRemark,orderContent);
    }
    @RequestMapping(value = "/updateorderstatus",method = RequestMethod.POST)
    public String changeStatus(String orderID,String status){
        System.out.println(orderID+" "+status);
        return ordersService.changeStatus(orderID,status);
    }
    @RequestMapping(value = "/deleteorder",method = RequestMethod.POST)
    public String deleteOrder(String orderID){
        System.out.println("删除订单");
        return ordersService.deleteOrder(orderID);
    }
    @GetMapping(value = "/admin/order/all")
    public List<OrdersBean> getAll(){
        return ordersService.getAll();
    }
}
