package be.sourcedbvba.devoxx.usecase

import be.sourcedbvba.devoxx.domain.ObjectMother.Companion.SALAD_PRODUCT_NAME
import be.sourcedbvba.devoxx.domain.ObjectMother.Companion.salad
import be.sourcedbvba.devoxx.domain.gateway.ProductGateway
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired

internal class FindProductsImplTest
@Autowired constructor(val productGateway: ProductGateway,
                       val findProducts: FindProducts) : UseCaseTest() {
    @Test
    fun find() {
        productGateway.create(salad())

        val result = findProducts.find(FindProducts.Request(SALAD_PRODUCT_NAME))

        assertThat(result.products).contains(salad().toUseCaseResponseModel())
    }
}