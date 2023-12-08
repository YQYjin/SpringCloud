package com.example.springcloud_provider.mapper;

import com.example.springcloud_provider.bean.AdministratorBean;

public interface AdministratorMapper {
    public AdministratorBean getByName(String username);
}
