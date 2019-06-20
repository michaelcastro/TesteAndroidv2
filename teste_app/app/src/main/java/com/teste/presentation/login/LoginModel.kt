package com.teste.presentation.login

import com.teste.domain.model.DataResponseLogin

class LoginModel {


}

class LoginViewModel {
    var dataResponseLogin : DataResponseLogin? = null
}

class LoginRequest {
    lateinit var user : String
    lateinit var password : String
}

class LoginResponse {
    var dataResponseLogin : DataResponseLogin? = null
}
