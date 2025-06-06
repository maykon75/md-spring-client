package com.client.project.domain.usecase;

import com.client.project.domain.model.CustomerRequest;
import com.client.project.domain.model.CustomerResponse;
import com.client.project.port.input.ICustomerInputPort;
import com.client.project.port.output.ICustomerOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUsecase implements ICustomerInputPort {

    private final ICustomerOutputPort customerOutputPort;

    public CustomerUsecase(ICustomerOutputPort customerOutputPort) {
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public CustomerResponse getById(Long id) {
        return customerOutputPort.getById(id);
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerOutputPort.getAll();
    }

    @Override
    public void post(CustomerRequest customerRequest) {
        customerOutputPort.post(customerRequest);
    }

    @Override
    public void update(Long id, CustomerRequest customerRequest) {
        customerOutputPort.update(id, customerRequest);
    }

    @Override
    public void delete(Long id) {
        customerOutputPort.delete(id);
    }
}
