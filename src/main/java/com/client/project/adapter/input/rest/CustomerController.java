package com.client.project.adapter.input.rest;


import com.client.project.adapter.input.rest.dto.CustomerRequestInputDTO;
import com.client.project.adapter.input.rest.dto.CustomerResponseInputDTO;
import com.client.project.adapter.input.rest.dto.mapper.CustomerInputMapper;
import com.client.project.port.input.ICustomerInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
public class CustomerController {

    private final ICustomerInputPort customerInputPort;

    private final CustomerInputMapper customerInputMapper;

    public CustomerController(final ICustomerInputPort customerInputPort, final CustomerInputMapper customerInputMapper) {
        this.customerInputPort = customerInputPort;
        this.customerInputMapper = customerInputMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseInputDTO> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(customerInputMapper.toDto(customerInputPort.getById(id)));
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponseInputDTO>> getAll() {
        return ResponseEntity.ok(customerInputMapper.listToDto(customerInputPort.getAll()));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> post(@RequestBody CustomerRequestInputDTO customerRequestInputDTO) {
        customerInputPort.post(customerInputMapper.toDomain(customerRequestInputDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody CustomerRequestInputDTO customerRequestInputDTO) {
        customerInputPort.update(id, customerInputMapper.toDomain(customerRequestInputDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        customerInputPort.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
