package com.ziery.produtos.services;

import com.ziery.produtos.models.ProductModel;
import com.ziery.produtos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Retornar todos produtos
    public  List<ProductModel> findAll() {
       return productRepository.findAll();

    }





}
