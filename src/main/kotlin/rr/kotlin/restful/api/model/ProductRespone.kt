package rr.kotlin.restful.api.model

import java.util.*

data class ProductRespone(

    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createAt: Date,
    val updateAt: Date?
)
