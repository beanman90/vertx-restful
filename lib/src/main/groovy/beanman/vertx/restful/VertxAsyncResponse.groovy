package beanman.vertx.restful

import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.util.concurrent.CompletableFuture

final class VertxAsyncResponse {

    static def okJson(CompletableFuture cf, AsyncResponse asyncResponse) {
        cf.whenCompleteAsync({ result, ex ->
            def response = Response.ok(result.toString()).type(MediaType.APPLICATION_JSON_TYPE).build()
            asyncResponse.resume(response)
        })
    }
}
