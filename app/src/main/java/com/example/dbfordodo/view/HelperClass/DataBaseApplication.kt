package com.example.dbfordodo.view.HelperClass

import android.app.Application
import com.example.dbfordodo.madel.DataBase.DodoDataBase

class DataBaseApplication : Application() {
    val database : DodoDataBase by lazy {
        DodoDataBase.getInstance(this)
    }

}
