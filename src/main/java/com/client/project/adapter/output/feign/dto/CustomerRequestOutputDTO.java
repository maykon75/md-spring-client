package com.client.project.adapter.output.feign.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestOutputDTO {
    private String name;
    private int age;
    private String email;
    private String cellPhone;
}
