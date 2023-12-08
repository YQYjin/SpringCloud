package com.example.springcloud_provider.serviceImpl;

import com.example.springcloud_provider.bean.ProductBean;
import com.example.springcloud_provider.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductMapper productMapper;
    public String addOneProduct(String productId,String productName,double unitPrice){
        int changes=productMapper.addOneProduct(productId,productName,unitPrice);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<ProductBean> getAll(){
        return productMapper.getAll();
    }
    public List<ProductBean> getByName(String productName){
        return productMapper.getByName(productName);
    }
    public String update(String id,String productName,double unitPrice,int inventoryNum)
    {
        int changes=productMapper.update(id,productName,unitPrice,inventoryNum);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public ProductBean getOneById(String id){
        return productMapper.getOneById(id);
    }
    public String delete(String id){
        int changes=productMapper.delete(id);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String addOne(String id,String productName,double unitPrice){
        int changes=productMapper.addOne(id,productName,unitPrice);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<ProductBean> getByOrderId(String id){
        return productMapper.getByOrderId(id);
    }
}
