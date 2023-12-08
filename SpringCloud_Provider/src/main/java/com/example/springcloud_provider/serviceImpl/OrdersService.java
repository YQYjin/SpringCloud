package com.example.springcloud_provider.serviceImpl;

import com.example.springcloud_provider.bean.CustomerBean;
import com.example.springcloud_provider.bean.OrdersBean;
import com.example.springcloud_provider.mapper.CustomerMapper;
import com.example.springcloud_provider.mapper.OrdersMapper;
import com.example.springcloud_provider.mapper.OrdersProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OrdersProductMapper ordersProductMapper;
    @Resource
    CustomerMapper customerMapper;
    public OrdersBean getById(String id){
        return ordersMapper.getById(id);
    }
    public List<OrdersBean> getAllByCustomerId(String id){
        return ordersMapper.getAllByCustomerId(id);
    }
    public String changeStatus(String id,String completionStatus){
        int changes=ordersMapper.changeStatus(id,completionStatus);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String deleteOrder(String id){
        int changes=ordersMapper.deleteOrder(id);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<OrdersBean> getAll(){
        return ordersMapper.getAll();
    }
    public String addOrder(double totalPrice, String customerName, String orderRemark, List<Map<String,String>> orderContent)
    {
        //输出orderContent
        CustomerBean customerBean=customerMapper.getByName(customerName);
        int item1=ordersMapper.addOneOrder(totalPrice,customerBean.getId(),orderRemark);
        System.out.println(item1);
        String newId=ordersMapper.getNew();
        for (Map<String,String> data : orderContent) {

                String key = data.get("productId");
                String value = data.get("quantity");
                ordersProductMapper.insertData(newId,key,value);
        }
        if(item1>0) return "success";
        else return "error";

    }
}
