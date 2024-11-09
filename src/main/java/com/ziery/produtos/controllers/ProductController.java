package com.ziery.produtos.controllers;

import com.ziery.produtos.dtos.ProductRecordDto;
import com.ziery.produtos.models.ProductModel;
import com.ziery.produtos.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


    //Retorna todos os produtos cadastrados
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    //Buscando por id
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable (value = "id") UUID id) {
        Optional<ProductModel> productModel0 = productRepository.findById(id); //faz a busca do id inserido
        if(productModel0.isEmpty()) {  //resposta se o id não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModel0.get()); //resposta se o id for encontrado
    }

    //Atualizar produto existente
    @PutMapping("/products/{id}")
    public  ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> productModel0 = productRepository.findById(id);
        if(productModel0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = productModel0.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }


}
