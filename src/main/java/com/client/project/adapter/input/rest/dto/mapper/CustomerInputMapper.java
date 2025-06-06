package com.client.project.adapter.input.rest.dto.mapper;

import com.client.project.adapter.input.rest.dto.CustomerRequestInputDTO;
import com.client.project.adapter.input.rest.dto.CustomerResponseInputDTO;
import com.client.project.domain.model.CustomerRequest;
import com.client.project.domain.model.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerInputMapper {

    CustomerRequest toDomain(CustomerRequestInputDTO customerRequestInputDTO);

    CustomerResponseInputDTO toDto(CustomerResponse customerResponse);

    List<CustomerResponseInputDTO> listToDto(List<CustomerResponse> customerResponseList);

}
