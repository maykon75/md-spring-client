package com.client.project.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerResponse {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String cellPhone;
}
