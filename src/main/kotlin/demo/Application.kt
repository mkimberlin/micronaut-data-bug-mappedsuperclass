package demo

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.event.annotation.EventListener
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import javax.inject.Inject
import javax.inject.Singleton

@OpenAPIDefinition(
        info = Info(
                title = "demo",
                version = "0.1"
        )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("demo")
                .mainClass(Application.javaClass)
                .start()
    }
}

@Singleton
class StartupListener {
    @EventListener
    fun onStartupEvent(event: StartupEvent) {
        val res = ResponseKey()
        responseKeyRepository.save(res)

        responseKeyRepository.findAll().forEach { res ->
            println(res.responseKey.toString() + ":" + res.isUsed)
        }

        res.isUsed = true
        responseKeyRepository.update(res)

        responseKeyRepository.findAll().forEach { res ->
            println(res.responseKey.toString() + ":" + res.isUsed)
        }
    }
    
    @Inject
    lateinit var responseKeyRepository: ResponseKeyRepository

}