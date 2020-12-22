package rr.kotlin.restful.api.service

import rr.kotlin.restful.api.model.CreateProductRequest
import rr.kotlin.restful.api.model.ListProductRequest
import rr.kotlin.restful.api.model.ProductRespone
import rr.kotlin.restful.api.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest):ProductRespone

    fun get(id:String):ProductRespone

    fun update(id:String,updateProductRequest: UpdateProductRequest):ProductRespone

    fun delete(id:String)

    fun list(listProductRequest: ListProductRequest):List<ProductRespone>


}
