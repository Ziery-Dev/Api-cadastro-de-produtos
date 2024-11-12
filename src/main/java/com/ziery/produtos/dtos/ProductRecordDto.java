package com.ziery.produtos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

                                //Ambos valores não poderão ser passados ao banco de dados brancos nem nulos
public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
