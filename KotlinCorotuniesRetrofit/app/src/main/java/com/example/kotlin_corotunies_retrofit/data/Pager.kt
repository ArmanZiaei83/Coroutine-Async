package com.example.kotlin_corotunies_retrofit.data

class Pager {

     var page : Int = 0
     var per_page : Int = 0
     var total : Int = 0
     var total_pages : Int = 0
     lateinit var data : ArrayList<Data>

     fun setPaget (page : Int){
         this.page = page
     }

     @JvmName("getPage1")
     fun getPage() : Int{
         return page
     }

    fun getPerPage() : Int{
        return per_page
    }

    @JvmName("getTotal1")
    fun getTotal() : Int{
        return total
    }

    fun getTotalPages() : Int {
        return total_pages
    }

    @JvmName("getData1")
    fun getData () : ArrayList<Data> {
        return data
    }

}
