package com.joblogic.data.datasource.remote.model

import com.joblogic.domain.model.Person

data class PersonResponse(val id: Int, val name: String, val number: String)

fun PersonResponse.toDomainModel() = Person(this.id, this.name, this.number)