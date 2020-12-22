package rr.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import rr.kotlin.restful.api.entity.Product

interface ProductRepository : JpaRepository<Product, String>