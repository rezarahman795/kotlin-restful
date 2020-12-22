package rr.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.*
import rr.kotlin.restful.api.model.*
import rr.kotlin.restful.api.service.ProductService

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebRespone<ProductRespone> {
        val productRespone = productService.create(body)
        return WebRespone(
            code = 200,
            status = "OK",
            data = productRespone
        )
    }

    @GetMapping(
        value = ["/api/products/{idProducts}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProducts") id: String): WebRespone<ProductRespone> {
        val productRespone = productService.get(id)
        return WebRespone(
            code = 200,
            status = "OK",
            data = productRespone
        )
    }

    @PutMapping(
        value = ["/api/products/{idProducts}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("idProducts") id: String,
        @RequestBody updateProductRequest: UpdateProductRequest
    ): WebRespone<ProductRespone> {
        val productRespone = productService.update(id, updateProductRequest)
        return WebRespone(
            code = 200,
            status = "OK",
            data = productRespone
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProducts}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProducts") id: String): WebRespone<String> {
        productService.delete(id)
        return WebRespone(
            code = 200,
            status = "OK",
            data = "data $id telah Dihapus"
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProduct(@RequestParam(value = "size", defaultValue = "10")size:Int,
                    @RequestParam(value = "page", defaultValue = "0" )page:Int): WebRespone<List<ProductRespone>> {
        val request = ListProductRequest(page = page, size = size)
        val respones = productService.list(request)
        return WebRespone(
            code = 200,
            status = "OK",
            data = respones
        )
    }

}