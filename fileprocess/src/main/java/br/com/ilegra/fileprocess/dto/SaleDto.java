package br.com.ilegra.fileprocess.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SaleDto {
    int idSale;
    ProductDto product;
    SailesManDto sailMan;   
}
