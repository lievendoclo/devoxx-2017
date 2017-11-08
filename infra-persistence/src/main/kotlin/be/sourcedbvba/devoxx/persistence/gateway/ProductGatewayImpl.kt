package be.sourcedbvba.devoxx.persistence.gateway

import be.sourcedbvba.devoxx.domain.entity.Product
import be.sourcedbvba.devoxx.domain.gateway.FindProductsQuery
import be.sourcedbvba.devoxx.domain.gateway.ProductGateway
import be.sourcedbvba.devoxx.persistence.morphia.ProductDocument
import be.sourcedbvba.devoxx.persistence.morphia.toNewDocument
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Component

@Component
class ProductGatewayImpl(private val productRepository: ProductRepository) : ProductGateway {
    override fun create(product: Product): String {
        val saved = productRepository.save(product.toNewDocument())
        return saved.businessKey
    }

    override fun findProducts(query: FindProductsQuery): List<Product> {
        return productRepository.findAll(query.toExample()).map { it.toDomain() }
    }
}

fun FindProductsQuery.toExample() : Example<ProductDocument> {
    val exampleMatcher = ExampleMatcher.matchingAll()
            .withIgnorePaths("id", "businessKey")
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
    return Example.of(ProductDocument("", "", nameContains!!), exampleMatcher)
}