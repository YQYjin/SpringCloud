package com.example.distributedhomework2.security;


import com.example.distributedhomework2.bean.AdministratorBean;
import com.example.distributedhomework2.serviceImpl.AdministratorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("尝试加载Admin: "+"username:"+username);

        AdministratorBean admin=adminService.getByName(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found with username: " + username);
        }
        String srcPassword=admin.getPassword();
        String adminID=admin.getId();

        //将adminID转为int
        int intID=Integer.parseInt(adminID);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        String password=bCryptPasswordEncoder.encode(srcPassword);
        MyUserDetail myUserDetail = new MyUserDetail(username, password, authorities);

        myUserDetail.setUserID(intID);

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
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {

            return userDetails.getUserID() == userID; // 用户拥有正确的身份和权限

        }

        return false;
    }
    // 更简洁的写法
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public boolean checkAdminPermission(UserDetails userDetails, long userID) {
//        return userDetails.getUserID() == userID;
//    }
}

