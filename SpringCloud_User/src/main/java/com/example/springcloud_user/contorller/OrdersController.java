package com.example.springcloud_user.contorller;

import com.example.springcloud_user.bean.ProductRequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {
    @Autowired
    RestTemplate restTemplate;
    String providerUrl = "http://192.168.173.104:8761";
    @RequestMapping(value = "/getorderinfo/{orderID}",method = RequestMethod.GET)
    public String loadById(@PathVariable String orderID){
        String serviceUrl=providerUrl+"/getorderinfo/"+orderID;
        System.out.println(serviceUrl);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getorderinfo!";
        }
    }
    @RequestMapping(value = "/employee/order/bycustomerid/{customerID}",method = RequestMethod.GET)
    public String loadByCustomerId(@PathVariable String customerID){
        String serviceUrl=providerUrl+"/employee/order/bycustomerid/"+customerID;
        System.out.println(serviceUrl);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getorderinfo!";
        }
    }
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public String addOneOrder( @RequestBody ProductRequestBean orderData){
        String serviceUrl = providerUrl+"/addOrder";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductRequestBean> requestEntity = new HttpEntity<>(orderData,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        else{
            return "Error calling addOrder!";
        }
    }
    @RequestMapping(value = "/updateorderstatus",method = RequestMethod.POST)
    public String changeStatus(String orderID,String status){
        String serviceUrl=providerUrl+"/updateorderstatus?";
        String requestBody= "orderID="+orderID+"&status="+status;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling updateorderstatus!";
        }

    }
    @RequestMapping(value = "/deleteorder",method = RequestMethod.POST)
    public String deleteOrder(String orderID){
        String serviceUrl=providerUrl+"/deleteorder?";
        String requestBody= "orderID="+orderID;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling deleteorder!";
        }
    }
    @GetMapping(value = "/admin/order/all")
    public String getAll(){
        String serviceUrl=providerUrl+"/admin/order/all";
        System.out.println(serviceUrl);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getorderinfo!";
        }
    }
}
