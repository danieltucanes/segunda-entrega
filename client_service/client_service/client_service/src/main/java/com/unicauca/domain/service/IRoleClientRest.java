package com.unicauca.domain.service;

import com.unicauca.domain.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user_service", url = "localhost:8001")

public interface IRoleClientRest {

    @GetMapping("/roles/")
    public List<Role> findAll();

}
