package be.sourcedbvba.devoxx.persistence.gateway

import be.sourcedbvba.devoxx.domain.entity.Product
import be.sourcedbvba.devoxx.domain.gateway.FindProductsQuery
import be.sourcedbvba.devoxx.domain.gateway.ProductGateway
import be.sourcedbvba.devoxx.persistence.morphia.ProductDocument
import org.springframework.stereotype.Component

@Component
class ProductGatewayImpl(private val productRepository: ProductRepository? = null) : ProductGateway {
    override fun create(product: Product): String {
        val saved = productRepository!!.save(product.toNewDocument())
        return saved.businessKey
    }

    override fun findProducts(query: FindProductsQuery): List<Product> {
        return productRepository!!.findByNameContains(query.nameContains).map { it.toDomain() }
    }
}

fun Product.toNewDocument(): ProductDocument {
    return ProductDocument(null, id, name);
}