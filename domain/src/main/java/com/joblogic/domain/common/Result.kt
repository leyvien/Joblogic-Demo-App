package com.joblogic.domain.common

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val errorMsg: String) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success => $data"
            is Failure -> "Failure => $errorMsg"
        }
    }
}
