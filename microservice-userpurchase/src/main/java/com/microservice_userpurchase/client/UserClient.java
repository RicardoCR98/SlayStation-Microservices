package com.microservice_userpurchase.client;

import com.microservice_user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user")
public interface UserClient {
    @GetMapping("/api/users/search/{id}")
    UserDTO getUserById(@PathVariable Integer id);
}
