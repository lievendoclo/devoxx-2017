package be.sourcedbvba.kali.springboot

import be.sourcedbvba.kali.persistence.PersistenceConfig
import be.sourcedbvba.kali.usecase.UseCaseConfig
import be.sourcedbvba.kali.web.WebConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(WebConfig::class,
        PersistenceConfig::class,
        UseCaseConfig::class)
class Wiring {

}