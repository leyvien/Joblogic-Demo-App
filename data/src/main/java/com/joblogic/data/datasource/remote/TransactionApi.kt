package com.joblogic.data.datasource.remote

import com.joblogic.data.datasource.remote.model.ItemResponse
import com.joblogic.data.datasource.remote.model.PersonResponse
import retrofit2.http.GET

interface TransactionApi {
    @GET("imkhan334/demo-1/call")
    suspend fun fetchItemsToCall(): List<PersonResponse>

    @GET("imkhan334/demo-1/buy")
    suspend fun fetchItemsToBuy(): List<ItemResponse>
}