package be.sourcedbvba.devoxx.web.model;

import be.sourcedbvba.devoxx.usecase.FindProducts

data class ProductJson(val id: String, val name: String)

fun FindProducts.Response.toJsonList() = products.map { ProductJson(it.id, it.name) }