package com.teste.domain.model

class Error(val code: Int, val message: String) {
    override fun toString(): String {
        return "Error(code='$code', message='$message')"
    }
}