package com.client.project.adapter.output.feign.dto.mapper;

import com.client.project.adapter.output.feign.dto.CustomerRequestOutputDTO;
import com.client.project.adapter.output.feign.dto.CustomerResponseOutputDTO;
import com.client.project.domain.model.CustomerRequest;
import com.client.project.domain.model.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerOutputMapper {

    CustomerResponse toDomain(CustomerResponseOutputDTO customerResponseOutputDTO);

    List<CustomerResponse> listToDomain(List<CustomerResponseOutputDTO> customerResponseOutputDTOList);

    CustomerRequestOutputDTO toDto(CustomerRequest customerRequest);

}
