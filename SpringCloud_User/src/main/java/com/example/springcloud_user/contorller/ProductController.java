package com.example.springcloud_user.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    RestTemplate restTemplate;
    String providerUrl = "http://SPRINGCLOUDPROVIDER";
    @RequestMapping(value = "/employee/addnewproduct",method = RequestMethod.POST)
    public String addOneProduct(@RequestBody Map<String, String> request){
        String productID=request.get("productID");
        String productName=request.get("productName");
        String unitPrice=request.get("unitPrice");

        String serviceUrl = providerUrl+"/employee/addnewproduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "productID="+productID+"&productName="+productName+"&unitPrice="+unitPrice;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        else{
            return "Error calling addnewproduct!";
            }

    }
    @RequestMapping(value = "/allProduct",method = RequestMethod.GET)
    public String getAll(){
        String serviceUrl=providerUrl+"/allProduct";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling allProduct!";
        }
    }
    @RequestMapping(value = "/queryProduct",method = RequestMethod.POST)
    public String getByName(String name){
        String serviceUrl=providerUrl+"/queryProduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "name="+name;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling queryProduct!";
        }
    }
    @RequestMapping(value = "/admin/modifyproduct",method = RequestMethod.POST)
    public String updateOne(String id,String name,double price,int inventory){
        String serviceUrl=providerUrl+"/admin/modifyproduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "id="+id+"&name="+name+"&price="+price+"&inventory="+inventory;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling modifyproduct!";
        }
    }
    @RequestMapping(value = "/admin/getproduct",method = RequestMethod.POST)
    public String getOneById(String id){
        String serviceUrl=providerUrl+"/admin/getproduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "id="+id;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getproduct!";
        }
    }
    @RequestMapping(value = "/admin/deleteproduct",method = RequestMethod.POST)
    public String deleteOne(String id){
        String serviceUrl=providerUrl+"/admin/deleteproduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "id="+id;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling deleteproduct!";
        }
    }
    @RequestMapping(value = "/admin/addproduct",method = RequestMethod.POST)
    public String addOne(String id,String productName,double unitPrice){
        String serviceUrl=providerUrl+"/admin/addproduct";
        HttpHeaders headers = new HttpHeaders();
        String requsetBody= "id="+id+"&productName="+productName+"&unitPrice="+unitPrice;
        HttpEntity<String> requestEntity = new HttpEntity<>(requsetBody,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,requestEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling addproduct!";
        }
    }
    @RequestMapping(value ="/getorderinfo/content/{orderID}",method = RequestMethod.GET)
    public String getByOrderId(@PathVariable String orderID){
        String serviceUrl=providerUrl+"/getorderinfo/content/"+orderID;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getorderinfo/content/{orderID}!";
        }
    }
}
