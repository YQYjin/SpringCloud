package com.example.springcloud_provider.mapper;

import com.example.springcloud_provider.bean.ProductBean;

import java.util.List;

public interface ProductMapper {
    int addOneProduct(String productId,String productName,double unitPrice);
    List<ProductBean> getAll();
    List<ProductBean> getByName(String productName);
    int update(String id,String productName,double unitPrice,int inventoryNum);
    ProductBean getOneById(String id);
    int delete(String id);
    int addOne(String id,String productName,double unitPrice);
    List<ProductBean> getByOrderId(String id);
}
