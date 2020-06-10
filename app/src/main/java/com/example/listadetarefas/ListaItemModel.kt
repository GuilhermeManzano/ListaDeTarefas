package com.example.listadetarefas

class ListaItemModel {
    var listaId: Int = 0
    var listaTexto: String? = null
    var listaData: String? = null

    constructor()

    //Recebe como parâmetro os campos que serão necessários para a criação da tabela
    constructor(lista_id: Int, lista_texto: String, lista_data: String) {
        this.listaId =  lista_id
        this.listaTexto = lista_texto
        this.listaData = lista_data
    }

    //É a criação, de fato, de uma nova tabela em um APP
    companion object{
        val LISTA_TABLE_NAME = "lista db"

        val LISTA_ID_COLUMN = "id"
        val LISTA_TEXT_COLUMN = "listaText"
        val LISTA_DATA_COLUMN = "listaData"

        val CREATE_TABLE = (
            "CREATE TABLE "
                + LISTA_TABLE_NAME + "("
                + LISTA_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LISTA_TEXT_COLUMN + " TEXT, "
                + LISTA_DATA_COLUMN + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ")")
    }

}