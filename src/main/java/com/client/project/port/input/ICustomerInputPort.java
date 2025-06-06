package com.client.project.port.input;

import com.client.project.domain.model.CustomerRequest;
import com.client.project.domain.model.CustomerResponse;

import java.util.List;

public interface ICustomerInputPort {

    CustomerResponse getById(Long id);

    List<CustomerResponse> getAll();

    void post(CustomerRequest customerRequest);

    void update(Long id, CustomerRequest customerRequest);

    void delete(Long id);
}
