package rr.kotlin.restful.api.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import rr.kotlin.restful.api.entity.ApiKey
import rr.kotlin.restful.api.repository.ApiKeyRepository

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "RAHASIA"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val entity =ApiKey(id = apiKey )
            apiKeyRepository.save(entity)
        }
    }
}