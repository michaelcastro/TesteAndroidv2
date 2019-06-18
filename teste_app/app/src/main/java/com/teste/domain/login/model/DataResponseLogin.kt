package com.teste.domain.login.model

class DataResponseLogin(val userAccount: UserAccount, val error: Error) {
    override fun toString(): String {
        return "DataResponseLogin(userAccount=$userAccount, error=$error)"
    }
}

class Error(val code: Int, val message: String) {
    override fun toString(): String {
        return "Error(code='$code', message='$message')"
    }
}