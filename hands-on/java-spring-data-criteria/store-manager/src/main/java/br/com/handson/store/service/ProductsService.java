package br.com.handson.store.service;

import br.com.handson.store.dto.ProductsDto;
import br.com.handson.store.model.Products;
import br.com.handson.store.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsDto createProduct(ProductsDto productsDto) {
        Products products = convertToModel(productsDto);
        Integer id = productsRepository.save(products).getId();
        productsDto.setId(id);

        return productsDto;
    }

    public List<ProductsDto> listProducts() {
        return productsRepository.findAll().stream().map(item -> convert(item)).collect(Collectors.toList());
    }

    public ProductsDto getProduct(Integer id) {
        Products products = productsRepository.getById(id);
        System.out.println("modelo: " + products.getId());
        return convert(products);
    }

    public ProductsDto updateProduct(Integer id, ProductsDto productsDto) {
        Products products = productsRepository.getById(id);
        if (!(productsDto.getName() == null)) {
            products.setName(productsDto.getName());
        }
        if (!(productsDto.getQuantity() == 0)) {
            products.setQuantity(productsDto.getQuantity());
        }
        return this.convert(productsRepository.save(products));
    }

    public ProductsDto convert(Products products) {
        return new ProductsDto(products.getId(), products.getName(), products.getQuantity());
    }

    public Products convertToModel(ProductsDto productsDto) {
        Products products = new Products();

        if(!(productsDto.getName() == null)) {
            products.setName(productsDto.getName());
        }
        if(!(productsDto.getQuantity() == null)) {
            products.setQuantity(productsDto.getQuantity());
        }

        return products;
    }

    public ProductsDto excludProduct(Integer id) {
        Products products = productsRepository.getById(id);
        productsRepository.delete(products);
        return this.convert(products);
    }
}
