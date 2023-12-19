package com.example.springcloud_user.contorller;//package com.example.springcloud_user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class StaffController {
    @Autowired
    RestTemplate restTemplate;
    String providerUrl = "http://localhost:8881";
    @RequestMapping(value = "/getemployeeinfo/{id}",method = RequestMethod.GET)
    public String getStaffInfo(@PathVariable String id){
        String serviceUrl = providerUrl+"/getemployeeinfo/"+id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling getemployeeinfo!";
        }
    }
    @RequestMapping(value = "/modifyemployee",method = RequestMethod.POST)
    public String changeStaff(@RequestParam String id, @RequestParam String newName, @RequestParam String newSex, @RequestParam String newPhone){
        String serviceUrl = providerUrl+"/modifyemployee?";
        String requestBody= "id="+id+"&newName="+newName+"&newSex="+newSex+"&newPhone="+newPhone;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling modifyemployee!";
        }
    }
    @RequestMapping(value = "/modifyemployee/delete",method = RequestMethod.POST)
    public String deleteStaff(String id){
        String serviceUrl = providerUrl+"/modifyemployee/delete?";
        String requestBody= "id="+id;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling modifyemployee/delete!";
        }

    }
    @RequestMapping(value = "/admin/allemployee",method = RequestMethod.GET)
    public String loadAll(){
        String serviceUrl = providerUrl+"/admin/allemployee";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling admin/allemployee!";
        }
    }
    @RequestMapping(value = "/admin/queryemployee",method = RequestMethod.POST)
    public String loadByNamePhone(String username,String phoneNumber){
        String serviceUrl = providerUrl+"/admin/queryemployee?";
        String requestBody= "username="+username+"&phoneNumber="+phoneNumber;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling admin/queryemployee!";
        }
    }
    @RequestMapping(value = "/admin/addemployee",method = RequestMethod.POST)
    public String addOne(String addID,String addName,String addPhone,String addSex){
        String serviceUrl = providerUrl+"/admin/addemployee?";
        String requestBody= "addID="+addID+"&addName="+addName+"&addPhone="+addPhone+"&addSex="+addSex;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling admin/addemployee!";
        }

    }
    @RequestMapping(value = "/modifyemployee/password",method = RequestMethod.POST)
    public String updatePwd(String id,String nowPassword,String newPassword){
        String serviceUrl = providerUrl+"/modifyemployee/password?";
        String requestBody= "id="+id+"&nowPassword="+nowPassword+"&newPassword="+newPassword;
        serviceUrl=serviceUrl+requestBody;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl,null,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return "Error calling modifyemployee/password!";
        }
    }
}
