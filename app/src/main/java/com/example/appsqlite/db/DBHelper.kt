package com.example.appsqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = (
                "CREATE TABLE " + TABLE_NAME + " ("
                        + ID_COL + " INTEGER PRIMARY KEY, " +
                        NAME_COL + " TEXT," +
                        END_COL + " TEXT," +
                        BAR_COL + " TEXT," +
                        CEP_COL + " TEXT," +
                        OBS_COL + " TEXT,"
                )
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPessoa(name: String, endereco: String, bairro: String, cep: String, observacoes: String) {
        val values = ContentValues()
        values.put(NAME_COL, name)
        values.put(END_COL, endereco)
        values.put(BAR_COL, bairro)
        values.put(CEP_COL, cep)
        values.put(OBS_COL, observacoes)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // objeto para definir as variáveis do banco de dados
    companion object{
        private val DATABASE_NAME = "appSQLite"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "CadastroPessoa"
        val ID_COL = "id"
        val NAME_COL = "name"
        val END_COL = "endereco"
        val BAR_COL = "bairro"
        val CEP_COL = "cep"
        val OBS_COL = "observacoes"
    }

}