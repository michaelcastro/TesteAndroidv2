package com.teste.domain.login.model

class UserAccount (val userId : Int, val name : String, val bankAccount : String, val agency : String, val balance : Float  ){
    override fun toString(): String {
        return "UserAccount(userId=$userId, name='$name', bankAccount='$bankAccount', agency='$agency', balance=$balance)"
    }
}