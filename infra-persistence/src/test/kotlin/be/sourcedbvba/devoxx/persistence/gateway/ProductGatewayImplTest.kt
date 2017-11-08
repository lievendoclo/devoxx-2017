package be.sourcedbvba.kali.persistence.gateway

import be.sourcedbvba.kali.domain.gateway.FindProductsQuery
import be.sourcedbvba.kali.domain.gateway.ProductGateway
import be.sourcedbvba.kali.persistence.PersistenceTestConfig
import be.sourcedbvba.kali.persistence.morphia.ProductDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = arrayOf(PersistenceTestConfig::class))
internal class ProductGatewayImplTest {
    @Autowired
    lateinit var productGateway : ProductGateway
    @Autowired
    lateinit var productRepository: ProductRepository

    @BeforeEach
    fun clearMongo() {
        productRepository.deleteAll();
    }

    @Test
    fun canHandleEmptyCollection() {
        val result = productGateway.findProducts(FindProductsQuery("test"))

        assertThat(result).hasSize(0)
    }

    @Test
    fun canHandleNoResults() {
        productRepository.save(ProductDocument(businessKey = "1", name = "salad"))

        val result = productGateway.findProducts(FindProductsQuery("steak"))

        assertThat(result).hasSize(0)
    }

    @Test
    fun canHandleSingleResult() {
        productRepository.save(ProductDocument(businessKey = "1", name = "spaghetti bolognese"))

        val result = productGateway.findProducts(FindProductsQuery("spag"))

        assertThat(result).hasSize(1)
    }

    @Test
    fun canHandleMultipleResults() {
        productRepository.save(listOf(ProductDocument(businessKey = "1", name = "spaghetti bolognese"),
                ProductDocument(businessKey = "2", name = "spaghetti carbonara")))

        val result = productGateway.findProducts(FindProductsQuery("spag"))

        assertThat(result).hasSize(2)
    }
}