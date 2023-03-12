package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.db.data.Size

class GetSize {
  fun  getListSize():List<Size>{
      val list = mutableListOf<Size>()

      list.add(Size(1,"Smail"))
      list.add(Size(2,"Normal"))
      list.add(Size(3,"Big"))
      return list
  }
}