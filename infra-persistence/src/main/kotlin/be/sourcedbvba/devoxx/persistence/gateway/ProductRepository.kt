package be.sourcedbvba.devoxx.persistence.gateway

import be.sourcedbvba.devoxx.persistence.morphia.ProductDocument
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.QueryByExampleExecutor

interface ProductRepository : PagingAndSortingRepository<ProductDocument, String>, QueryByExampleExecutor<ProductDocument> {
    fun findByNameContains(nameContains: String?) : List<ProductDocument>
}