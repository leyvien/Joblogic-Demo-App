package com.joblogic.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joblogic.domain.model.Item

@Entity(tableName = "ItemToSell")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int,
)

fun populateSellItemsData() = listOf(
    ItemEntity(1, "iPhone X", 150000, 1, 2),
    ItemEntity(2, "TV", 38000, 2, 2),
    ItemEntity(3, "Table", 12000, 1, 2),
)

fun ItemEntity.toDomainModel() =
    Item(this.id, this.name, this.price, this.quantity, this.type)

