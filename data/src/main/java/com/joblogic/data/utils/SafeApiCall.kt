package com.joblogic.data.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import com.joblogic.domain.common.Result

suspend inline fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    crossinline apiCall: suspend () -> T,
): Result<T> {
    return withContext(dispatcher) {
        try {
            val apiResponse = apiCall.invoke()
            Result.Success(apiResponse)
        } catch (e: TimeoutCancellationException) {
            throw e
        } catch (e: CancellationException) {
            throw e
        } catch (e: Throwable) {
            Result.Failure(e.message!!)
        }
    }
}

