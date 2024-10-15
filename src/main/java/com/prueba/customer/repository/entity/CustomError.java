package com.prueba.customer.repository.entity;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    String codeErro;
    String messageError;
}
