package be.sourcedbvba.devoxx.domain

import be.sourcedbvba.devoxx.domain.entity.Product

class ObjectMother {
    companion object {
        const val SALAD_PRODUCT_NAME = "salad"
        fun salad() = Product("1", SALAD_PRODUCT_NAME)
    }
}
