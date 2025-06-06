package com.client.project.adapter.output.feign;

import com.client.project.adapter.output.feign.config.client.ICustomerFeignClient;
import com.client.project.adapter.output.feign.dto.mapper.CustomerOutputMapper;
import com.client.project.domain.model.CustomerRequest;
import com.client.project.domain.model.CustomerResponse;
import com.client.project.port.output.ICustomerOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerOutputFeignAdapter implements ICustomerOutputPort {

    private final CustomerOutputMapper customerOutputMapper;

    private final ICustomerFeignClient customerFeignClient;

    public CustomerOutputFeignAdapter(final CustomerOutputMapper customerOutputMapper, final ICustomerFeignClient customerFeignClient) {
        this.customerOutputMapper = customerOutputMapper;
        this.customerFeignClient = customerFeignClient;
    }

    @Override
    public CustomerResponse getById(Long id) {
        return customerOutputMapper.toDomain(customerFeignClient.getById(id));
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerOutputMapper.listToDomain(customerFeignClient.getAll());
    }

    @Override
    public void post(CustomerRequest customerRequest) {
        customerFeignClient.post(customerOutputMapper.toDto(customerRequest));
    }

    @Override
    public void update(Long id, CustomerRequest customerRequest) {
        customerFeignClient.update(id, customerOutputMapper.toDto(customerRequest));
    }

    @Override
    public void delete(Long id) {
        customerFeignClient.delete(id);
    }
}
