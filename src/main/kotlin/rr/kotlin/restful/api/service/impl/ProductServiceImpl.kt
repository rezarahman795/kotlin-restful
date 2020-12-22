package rr.kotlin.restful.api.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import rr.kotlin.restful.api.entity.Product
import rr.kotlin.restful.api.error.NotFoundException
import rr.kotlin.restful.api.model.CreateProductRequest
import rr.kotlin.restful.api.model.ListProductRequest
import rr.kotlin.restful.api.model.ProductRespone
import rr.kotlin.restful.api.model.UpdateProductRequest
import rr.kotlin.restful.api.repository.ProductRepository
import rr.kotlin.restful.api.service.ProductService
import rr.kotlin.restful.api.validation.ValidationUtil
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductRespone {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createAt = Date(),
            updateAt = null
        )

        productRepository.save(product)

        return convertProductToProduct(product)
    }

    override fun get(id: String): ProductRespone {
        val product = findByIdorNotNull(id)

        return convertProductToProduct(product)

    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductRespone {

        val product = findByIdorNotNull(id)

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updateAt = Date()
        }
        productRepository.save(product)

        return convertProductToProduct(product)
    }

    override fun delete(id: String) {
        val product = findByIdorNotNull(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductRespone> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page,listProductRequest.size))
        val product = page.get().collect(Collectors.toList())

        return product.map {
            convertProductToProduct(it)
        }
    }

    private fun convertProductToProduct(product: Product): ProductRespone {
        return ProductRespone(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createAt = product.createAt,
            updateAt = product.updateAt
        )
    }

    private fun findByIdorNotNull(id: String): Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
    }
}