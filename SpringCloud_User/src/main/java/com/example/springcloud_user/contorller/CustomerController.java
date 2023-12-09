package com.example.springcloud_user.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    RestTemplate restTemplate;
    String providerUrl = "http://SPRINGCLOUDPROVIDER";
    @RequestMapping(value = "/getcustomerinfo/{customerID}",method = RequestMethod.GET)
    public String load(@PathVariable String customerID){
        String serviceUrl=providerUrl+"/getcustomerinfo/"+customerID;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }

    }
    @RequestMapping(value = "/getcustomerinfo/byorderID/{orderID}",method = RequestMethod.GET)
    public String loadbyOrder(@PathVariable String orderID){
        String serviceUrl=providerUrl+"/getcustomerinfo/byorderID/"+orderID;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }


    }
    @RequestMapping(value = "/employee/querycustomer",method = RequestMethod.POST)
    public String loadByNamePhone(String userName, String phoneNumber, String employeeID){
        String serviceUrl=providerUrl+"/employee/querycustomer";
        HttpHeaders headers=new HttpHeaders();
        String requestBody="userName="+userName+"&phoneNumber="+phoneNumber+"&employeeID="+employeeID;
        HttpEntity<String> requsetEntity=new HttpEntity<>(requestBody,headers);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,requsetEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }

    }
    @RequestMapping(value = "/modifycustomer",method = RequestMethod.POST)
    public String update(String id,String newName,String newSex,String newPhone,double newConsumption,String newAddress){
        String serviceUrl=providerUrl+"/modifycustomer";
        HttpHeaders headers=new HttpHeaders();
        String requestBody="id="+id+"&newName="+newName+"&newSex="+newSex+"&newPhone="+newPhone+"&newConsumption="+newConsumption+"&newAddress="+newAddress;
        HttpEntity<String> requsetEntity=new HttpEntity<>(requestBody,headers);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,requsetEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }

    }
    @RequestMapping(value = "/modifycustomer/delete",method = RequestMethod.POST)
    public String deleteOne(String id){
        String serviceUrl=providerUrl+"/modifycustomer/delete";
        HttpHeaders headers=new HttpHeaders();
        String requestBody="id="+id;
        HttpEntity<String> requsetEntity=new HttpEntity<>(requestBody,headers);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,requsetEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }
    }
    @RequestMapping(value = "/employee/getcustomer",method = RequestMethod.POST)
    public String getByStaffId(String employeeID){
        String serviceUrl=providerUrl+"/employee/getcustomer";
        HttpHeaders headers=new HttpHeaders();
        String requestBody="employeeID="+employeeID;
        HttpEntity<String> requsetEntity=new HttpEntity<>(requestBody,headers);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,requsetEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }
    }
    @RequestMapping(value = "/employee/addcustomer",method = RequestMethod.POST)
    public String addOne(String id,String username,String sex,String phoneNumber,String address,String employeeID){
        String serviceUrl=providerUrl+"/employee/addcustomer";
        HttpHeaders headers=new HttpHeaders();
        String requestBody="id="+id+"&username="+username+"&sex="+sex+"&phoneNumber="+phoneNumber+"&address="+address+"&employeeID="+employeeID;
        HttpEntity<String> requsetEntity=new HttpEntity<>(requestBody,headers);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,requsetEntity,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }
    }
    @GetMapping(value = "/admin/customer/all")
    public String getAll(){
        String serviceUrl=providerUrl+"/admin/customer/all";
        ResponseEntity<String> responseEntity= restTemplate.getForEntity(serviceUrl,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }else{
            return "Error calling getcustomerinfo!";
        }
    }
}
