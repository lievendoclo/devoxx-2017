package be.sourcedbvba.devoxx.web

import be.sourcedbvba.devoxx.usecase.CreateProduct
import be.sourcedbvba.devoxx.usecase.FindProducts
import be.sourcedbvba.devoxx.web.model.ProductJson
import be.sourcedbvba.devoxx.web.model.toJsonList
import com.googlecode.jsonrpc4j.JsonRpcService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

const val PRODUCT_RPC_PATH = "/rpc/product"

@JsonRpcService(PRODUCT_RPC_PATH)
interface ProductRpcService {
    fun findProducts(nameStartsWith: String?): List<ProductJson>
    fun createProduct(name: String): String
}

@JsonRpcService(PRODUCT_RPC_PATH)
@Component
class ProductRpcServiceImpl(val findProducts: FindProducts,
                            val createProduct: CreateProduct) : ProductRpcService {
    override fun createProduct(name: String): String {
        return createProduct.create(CreateProduct.Request(name)).id;
    }

    @GetMapping
    override fun findProducts(nameStartsWith: String?): List<ProductJson> {
        return findProducts.find(FindProducts.Request(nameStartsWith))
                .toJsonList()
    }
}