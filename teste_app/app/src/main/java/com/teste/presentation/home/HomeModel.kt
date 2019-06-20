package com.teste.presentation.home

import com.teste.domain.model.Recents

class HomeModel {
}

class HomeViewModel {
    var recents : Recents? = null
    var message : String = ""
}

class HomeRequest {
    var idUser : Int = 0
}

class HomeResponse {
    var recents : Recents? = null
    var message : String = ""
}
