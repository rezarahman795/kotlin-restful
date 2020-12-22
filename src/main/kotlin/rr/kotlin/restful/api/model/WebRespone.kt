package rr.kotlin.restful.api.model

data class WebRespone<T>(
    val code: Int,
    val status: String,
    val data: T
)