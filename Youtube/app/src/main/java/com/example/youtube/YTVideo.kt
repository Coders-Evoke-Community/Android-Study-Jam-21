package com.example.youtube

class YTVideo {

    var thumbnailId : Int = 0
    var title : String = ""
    var channel : String = ""
    var viewsCount : Long = 0
    //We have taken date as a string here just for simplicity
    //Date may be stored in "Date" class format or time in milliseconds format
    //But those require extra formatting while showing in UI
    var date : String = ""

}