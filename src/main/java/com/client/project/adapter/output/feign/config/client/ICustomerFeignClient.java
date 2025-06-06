package com.client.project.adapter.output.feign.config.client;

import com.client.project.adapter.output.feign.dto.CustomerRequestOutputDTO;
import com.client.project.adapter.output.feign.dto.CustomerResponseOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer", url = "${custom.base-url}")
public interface ICustomerFeignClient {

    @GetMapping(path = "/api/db/{id}")
    CustomerResponseOutputDTO getById(@PathVariable("id") Long id);

    @GetMapping(path = "/api/db")
    List<CustomerResponseOutputDTO> getAll();

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/api/db")
    void post(@RequestBody CustomerRequestOutputDTO customerRequestOutputDTO);

    @PutMapping(produces = "application/json", consumes = "application/json", path = "/api/db/{id}")
    void update(@PathVariable("id") Long id, @RequestBody CustomerRequestOutputDTO customerRequestOutputDTO);

    @DeleteMapping(path = "/api/db/{id}")
    void delete(@PathVariable("id") Long id);

}
