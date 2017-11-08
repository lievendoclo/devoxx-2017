package be.sourcedbvba.devoxx.springboot

import be.sourcedbvba.devoxx.persistence.PersistenceConfig
import be.sourcedbvba.devoxx.usecase.UseCaseConfig
import be.sourcedbvba.devoxx.web.WebConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(WebConfig::class,
        PersistenceConfig::class,
        UseCaseConfig::class)
class Wiring {

}