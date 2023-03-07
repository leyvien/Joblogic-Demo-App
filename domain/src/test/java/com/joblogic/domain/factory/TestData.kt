package com.joblogic.domain.factory

import com.joblogic.domain.model.Item
import com.joblogic.domain.model.Person

object TestData {
    val callListingItems = listOf(
        Person(1,"Test Person 1", "1"),
        Person(2,"Test Person 2", "2"),
        Person(3,"Test Person 3", "3")
    )
    val buyListingItems = listOf(
        Item(1, "Item 1", 1, 1, 1),
        Item(2, "Item 2", 2, 2, 1),
        Item(3, "Item 3", 3, 3, 1)
    )
    val sellListingItems = listOf(
        Item(1, "Item 1", 1, 1, 2),
        Item(2, "Item 2", 2, 2, 2),
        Item(3, "Item 3", 3, 3, 2)
    )
}