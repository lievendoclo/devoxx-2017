package be.sourcedbvba.devoxx.usecase

interface CreateProduct {
    fun create(request: Request): Response

    data class Request(val name: String)

    data class Response(val id: String)
}

