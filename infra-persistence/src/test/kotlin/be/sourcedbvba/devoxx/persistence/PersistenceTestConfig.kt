package be.sourcedbvba.kali.persistence

import com.github.fakemongo.Fongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate

const val TEST_DATABASE_NAME = "kalitest"

class PersistenceTestConfig : PersistenceConfig() {
    @Bean
    fun mongoTemplate() : MongoTemplate {
        return MongoTemplate(Fongo(getDatabaseName()).mongo, getDatabaseName())
    }

    fun getDatabaseName(): String {
        return TEST_DATABASE_NAME;
    }
}
