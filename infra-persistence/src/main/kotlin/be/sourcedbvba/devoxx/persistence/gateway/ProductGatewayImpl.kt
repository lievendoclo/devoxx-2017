package be.sourcedbvba.kali.persistence.gateway

import be.sourcedbvba.kali.domain.entity.Product
import be.sourcedbvba.kali.domain.gateway.FindProductsQuery
import be.sourcedbvba.kali.domain.gateway.ProductGateway
import be.sourcedbvba.kali.persistence.morphia.ProductDocument
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

fun Product.toNewDocument() : ProductDocument {
    return ProductDocument(null, id, name);
}

fun FindProductsQuery.toExample() : Example<ProductDocument> {
    val exampleMatcher = ExampleMatcher.matchingAll()
            .withIgnorePaths("id", "businessKey")
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
    return Example.of(ProductDocument("", "", nameContains!!), exampleMatcher)
}