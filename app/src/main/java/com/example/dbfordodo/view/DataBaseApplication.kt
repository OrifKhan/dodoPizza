package com.example.dbfordodo.view

import android.app.Application
import com.example.dbfordodo.db.dao.dbMain.DodoDataBase

class DataBaseApplication : Application() {
    val database : DodoDataBase by lazy {
        DodoDataBase.getInstance(this)
    }

}
