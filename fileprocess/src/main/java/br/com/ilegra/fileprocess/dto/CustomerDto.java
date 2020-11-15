package br.com.ilegra.fileprocess.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDto {
    Long cnpj;
    String name;
    String businessArea;
}
