package br.com.handson.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {

    private Integer id;
    private List<ProductsDto> productsDtos;
}
