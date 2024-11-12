package com.ziery.produtos.services;

import com.ziery.produtos.models.ProductModel;
import com.ziery.produtos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Método create
    public ProductModel save(ProductModel product) {
        return  productRepository.save(product);

    }

    //Retornar todos produtos
    public  List<ProductModel> findAllProducts() {
       return productRepository.findAll();

    }

    //Buscar por id
    public Optional<ProductModel> findProdutById(UUID id) {
        return productRepository.findById(id);
    }

    //atualizar produto
    public ProductModel updateProduct( UUID id) {
        Optional <ProductModel> productModel = findProdutById(id);
        return  productRepository.save(productModel.get());


    }
    //deletar produto
    public boolean deleteProduct(UUID id) {
        Optional <ProductModel> productModel = findProdutById(id);
        if(productModel.isEmpty()) {
            return false;

        }
        productRepository.delete(productModel.get());
        return true;
    }









}
