package be.sourcedbvba.kali.usecase

import be.sourcedbvba.kali.domain.entity.Product
import be.sourcedbvba.kali.domain.gateway.ProductGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateProductImpl(val productGateway: ProductGateway) : CreateProduct {

    override fun create(request: CreateProduct.Request): CreateProduct.Response {
        val id = productGateway.create(request.toDomain())
        return CreateProduct.Response(id)
    }
}

fun CreateProduct.Request.toDomain() : Product {
    return Product(UUID.randomUUID().toString(), name)
}