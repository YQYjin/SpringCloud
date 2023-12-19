package com.example.distributedhomework2.security;

import com.example.distributedhomework2.bean.StaffBean;
import com.example.distributedhomework2.serviceImpl.StaffService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeUserDetailSerivce implements UserDetailsService {

    @Resource
    StaffService staffService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("尝试加载User: "+"username:"+username);

        StaffBean worker=staffService.getByName(username);
        if (worker == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

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
