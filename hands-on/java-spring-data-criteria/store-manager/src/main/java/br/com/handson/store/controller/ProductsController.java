package br.com.handson.store.controller;

import br.com.handson.store.dto.ProductsDto;
import br.com.handson.store.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<ProductsDto> createProduct(@RequestBody @Valid ProductsDto productsDto) {
        return ResponseEntity.ok(productsService.createProduct(productsDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductsDto>> listProducts() {
        return ResponseEntity.ok(productsService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productsService.getProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable Integer id, @RequestBody ProductsDto productsDto) {
        return ResponseEntity.ok(productsService.updateProduct(id, productsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsDto> excludProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productsService.excludProduct(id));
    }

}
