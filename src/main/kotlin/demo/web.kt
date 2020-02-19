package demo

import io.micronaut.http.annotation.*

@Controller("/")
class IndexController {

    @Get
    fun index(@Header("X-Session-Id") sessionId: String, @QueryValue name: String): String {
        return sessionId + name
    }

    @Post
    fun create(@Header("X-Session-Id") sessionId: String, name: String): String {
        return sessionId + name
    }

    /**
     * find2
     *
     * @param sessionId sessionId
     * @param name name
     * @return sessionId + name
     */
    @Get("/find2")
    fun find2(@QueryValue sessionId: String, @QueryValue name: String): String {
        return sessionId + name
    }

    @Get("/find3")
    fun find3(name: String): String {
        return name
    }

    @Post("/create2")
    fun create2(sessionId: String, name: String): String {
        return sessionId + name
    }
}