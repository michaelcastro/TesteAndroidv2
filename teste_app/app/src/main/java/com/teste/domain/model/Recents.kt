package com.teste.domain.model

class Recents (val statementList : ArrayList<StatementList>, val error: Error){

    constructor() : this(arrayListOf(), Error(0, ""))

    override fun toString(): String {
        return "Recents(statementList=$statementList, error=$error)"
    }
}

class StatementList(var title : String, var desc : String, var date : String, var value : Float){
    var valeuFormatted = ""
    override fun toString(): String {
        return "statementList(title='$title', desc='$desc', date='$date', value=$value)"
    }
}
