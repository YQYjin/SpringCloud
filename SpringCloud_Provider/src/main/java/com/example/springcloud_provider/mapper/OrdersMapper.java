package com.example.springcloud_provider.mapper;

import com.example.springcloud_provider.bean.OrdersBean;

import java.util.List;

public interface OrdersMapper {
    OrdersBean getById(String id);
    List<OrdersBean> getAllByCustomerId(String id);
    int addOneOrder(double amountMoney,String id,String notes);
    int changeStatus(String id,String completionStatus);
    int deleteOrder(String orderID);
    List<OrdersBean> getAll();
    String getNew();

}
