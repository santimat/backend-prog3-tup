package com.santi.learningspringboot.dto.request.product;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductUpdatable {
    @Nullable
    private String name;
    @Nullable
    private String description;
    @Nullable
    private Double price;
    @Nullable
    private Boolean active;
    @Nullable
    private Integer stock;

    public ProductUpdatable() {
    }

    public ProductUpdatable(@Nullable String name, @Nullable String description, @Nullable Double price, @Nullable Boolean active, @Nullable Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.stock = stock;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public Double getPrice() {
        return price;
    }

    public void setPrice(@Nullable Double price) {
        this.price = price;
    }

    @Nullable
    public Boolean getActive() {
        return active;
    }

    public void setActive(@Nullable Boolean active) {
        this.active = active;
    }

    @Nullable
    public Integer getStock() {
        return stock;
    }

    public void setStock(@Nullable Integer stock) {
        this.stock = stock;
    }
}
