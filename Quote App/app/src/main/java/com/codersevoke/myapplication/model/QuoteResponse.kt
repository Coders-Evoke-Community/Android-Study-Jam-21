package com.codersevoke.myapplication.model


import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("_id")
    var id: String?,
    @SerializedName("author")
    var author: String?,
    @SerializedName("authorSlug")
    var authorSlug: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("length")
    var length: String?
)