package rr.kotlin.restful.api.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,

    @Column(name = "name")
    var name: String,
    @Column(name = "price")
    var price: Long,
    @Column(name = "quantity")
    var quantity: Int,
    @Column(name = "create_at")
    var createAt: Date,
    @Column(name = "update_a")
    var updateAt: Date?
)

