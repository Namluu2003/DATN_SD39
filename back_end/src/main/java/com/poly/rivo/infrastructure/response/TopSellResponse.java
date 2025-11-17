package com.poly.rivo.infrastructure.response;

public interface TopSellResponse {
    String getName();
    String getImages();
    Long getMinPrice();
    Long getMaxPrice();
    String getBrand();
    String getCategory();
    String getSole();
    Long getQuantitySold();
}
