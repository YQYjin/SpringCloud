package com.example.springcloud_user.security;


import com.example.springcloud_user.bean.StaffBean;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeUserDetailSerivce implements UserDetailsService {

    @Autowired
    RestTemplate restTemplate;
    String providerUrl = "http://localhost:8881";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("尝试加载User: "+"username:"+username);
        String serviceUrl=providerUrl+"/employee/getpwd?";
        String encodedText="";
        try {
            encodedText = URLEncoder.encode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String requestBody="username="+encodedText;
        serviceUrl=serviceUrl+requestBody;
        System.out.println("serviceUrl:"+serviceUrl);
        ResponseEntity<String> responseEntity= restTemplate.postForEntity(serviceUrl,null,String.class);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new UsernameNotFoundException("Admin not found with username: " + username);
        }
        String response=responseEntity.getBody();
        System.out.println("response:"+response);
        StaffBean worker=new Gson().fromJson(response,StaffBean.class);

        String srcPassword=worker.getPassword();
        int userID=Integer.parseInt(worker.getId());

        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_USER");

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        String password=bCryptPasswordEncoder.encode(srcPassword);
        MyUserDetail myUserDetail = new MyUserDetail(username, password, Collections.singleton(grantedAuthority));

        myUserDetail.setUserID(userID);

        return myUserDetail;

    }
    public boolean checkUserID(Authentication authentication, int userID) {
        //首先检验用户是否登录
        if(authentication.getPrincipal().equals("anonymousUser")){
            return false;
        }
        MyUserDetail userDetails = (MyUserDetail) authentication.getPrincipal();
        //获取用户的权限
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        // 检查用户权限
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {

            return userDetails.getUserID() == userID; // 用户拥有正确的身份和权限
        }

        return false;
    }
}
