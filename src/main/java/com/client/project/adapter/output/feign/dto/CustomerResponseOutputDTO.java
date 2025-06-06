package com.client.project.adapter.output.feign.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerResponseOutputDTO {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String cellPhone;
}
