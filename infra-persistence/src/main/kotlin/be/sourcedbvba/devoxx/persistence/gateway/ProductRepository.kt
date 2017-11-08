package be.sourcedbvba.kali.persistence.gateway

import be.sourcedbvba.kali.persistence.morphia.ProductDocument
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.QueryByExampleExecutor

interface ProductRepository : PagingAndSortingRepository<ProductDocument, String>, QueryByExampleExecutor<ProductDocument> {
}