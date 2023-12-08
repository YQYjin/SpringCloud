package com.example.springcloud_provider.serviceImpl;

import com.example.springcloud_provider.bean.AdministratorBean;
import com.example.springcloud_provider.mapper.AdministratorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdministratorService {
    @Resource
    AdministratorMapper administratorMapper;
    public AdministratorBean getByName(String username){
        return administratorMapper.getByName(username);
    }
}
