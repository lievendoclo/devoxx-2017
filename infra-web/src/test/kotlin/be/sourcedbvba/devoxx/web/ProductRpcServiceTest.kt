package be.sourcedbvba.kali.web

import be.sourcedbvba.kali.usecase.*
import be.sourcedbvba.kali.web.model.ProductJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock

internal class ProductRpcServiceTest() {
    val findProducts = mock(FindProducts::class.java)
    val createProduct = mock(CreateProduct::class.java)

    val productController = ProductRpcServiceImpl(findProducts, createProduct)

    @Test
    fun findProducts() {
        doReturn(FindProducts.Response(listOf(FindProducts.Response.Product("1", "test"))))
                .`when`(findProducts).find(FindProducts.Request("t"))

        val result = productController.findProducts("t")

        assertThat(result).contains(ProductJson("1", "test"))
    }

}