package be.sourcedbvba.devoxx.domain.gateway

import be.sourcedbvba.devoxx.domain.entity.Product

interface ProductGateway {
    fun findProducts(query: FindProductsQuery) : List<Product>
    fun create(product: Product): String
}

data class FindProductsQuery(val nameContains: String?)