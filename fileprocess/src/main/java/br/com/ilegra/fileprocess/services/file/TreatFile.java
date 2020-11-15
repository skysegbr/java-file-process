package br.com.ilegra.fileprocess.services.file;

import br.com.ilegra.fileprocess.dto.CustomerDto;
import br.com.ilegra.fileprocess.dto.ProductDto;
import br.com.ilegra.fileprocess.dto.SailesManDto;
import br.com.ilegra.fileprocess.dto.SaleDto;


public class TreatFile {

    public void trea(String line, String delimiter){
        //TODO verificar uma forma de melhorar isso! 
        String[] list;
        list = line.split(delimiter);
        if ("001".equals(list[0])){
            SailesManDto sailesManDto = new SailesManDto();

            sailesManDto.setCpf(Long.parseLong(list[1]));
            sailesManDto.setName(list[2]);
            sailesManDto.setSalary(Float.parseFloat(list[3]));
            // sendQueue(sailesManDto); 
                
        }else if ("002".equals(list[0])){
            CustomerDto customerDto =  new CustomerDto();

            customerDto.setCnpj(Long.parseLong(list[1]));
            customerDto.setName(list[2]);
            customerDto.setBusinessArea(list[3]);
            // sendQueue(customerDto);

        } else{
            SaleDto saleDto =  new SaleDto();
            ProductDto productDto = new ProductDto();
            SailesManDto sailesManDto = new SailesManDto();

            saleDto.setIdSale(Integer.parseInt(list[1]));
            String[] productList;
            productList = list[2].split(",");
            
            for (String prod : productList){
                String[] item = prod.split("-");
                productDto.setIdProduct(Integer.parseInt(item[0]));
                productDto.setQuantity(Integer.parseInt(item[1]));
                productDto.setPrice(Float.parseFloat(item[2]));
            }
            sailesManDto.setName(list[3]);
            // sendQueue(sailesManDto);
        }

    }

}
