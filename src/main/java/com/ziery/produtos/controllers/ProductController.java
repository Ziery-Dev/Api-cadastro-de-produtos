package com.ziery.produtos.controllers;

import com.ziery.produtos.dtos.ProductRecordDto;
import com.ziery.produtos.models.ProductModel;
import com.ziery.produtos.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //Aqui na classe no método save, a requisição vai para a classe dto onde é feito as validações iniciais, e depois é convertido para model e salvo no banco de dados
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel); //conversão de dto para o model
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }


}
