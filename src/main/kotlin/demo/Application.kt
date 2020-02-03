package demo

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("demo")
                .mainClass(Application.javaClass)
                .start()
    }
}
