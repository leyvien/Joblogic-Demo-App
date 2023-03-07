package com.joblogic.data.datasource.remote.model

import com.joblogic.domain.model.Item

data class ItemResponse(
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int,
)

fun ItemResponse.toDomainModel() =
    Item(this.id, this.name, this.price, this.quantity, this.type)