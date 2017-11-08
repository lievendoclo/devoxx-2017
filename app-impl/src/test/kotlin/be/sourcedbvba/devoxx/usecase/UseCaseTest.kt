package be.sourcedbvba.kali.usecase

import be.sourcedbvba.kali.persistence.PersistenceTestConfig
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = arrayOf(PersistenceTestConfig::class, UseCaseConfig::class))
abstract internal class UseCaseTest {
    constructor()
}