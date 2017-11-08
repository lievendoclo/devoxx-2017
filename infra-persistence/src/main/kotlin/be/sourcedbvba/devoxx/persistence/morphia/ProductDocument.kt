package be.sourcedbvba.devoxx.persistence.morphia

import be.sourcedbvba.devoxx.domain.entity.Product
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class ProductDocument(@Id val id: String? = null, val businessKey: String, val name: String) {
    fun toDomain(): Product {
        return Product(businessKey, name)
    }
}

fun Product.toNewDocument() : ProductDocument {
    return ProductDocument(null, id, name);
}


