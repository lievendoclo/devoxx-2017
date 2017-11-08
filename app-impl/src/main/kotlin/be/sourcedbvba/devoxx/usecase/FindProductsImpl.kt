package be.sourcedbvba.kali.usecase

import be.sourcedbvba.kali.domain.entity.Product
import be.sourcedbvba.kali.domain.gateway.FindProductsQuery
import be.sourcedbvba.kali.domain.gateway.ProductGateway
import org.springframework.stereotype.Component

@Component
class FindProductsImpl(val productGateway: ProductGateway) : FindProducts {
    override fun find(request: FindProducts.Request): FindProducts.Response {
        val result = productGateway.findProducts(FindProductsQuery(request.nameContains))
                .map { it.toUseCaseResponseModel() }
        return FindProducts.Response(result)
    }
}

fun Product.toUseCaseResponseModel() : FindProducts.Response.Product {
    return FindProducts.Response.Product(id, name)
}
