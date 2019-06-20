package com.teste.domain.model

class DataResponseLogin(val userAccount: UserAccount, val error: Error) {
    override fun toString(): String {
        return "DataResponseLogin(userAccount=$userAccount, error=$error)"
    }
}
