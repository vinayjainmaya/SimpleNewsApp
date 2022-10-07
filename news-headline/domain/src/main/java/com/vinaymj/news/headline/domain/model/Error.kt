package com.vinaymj.news.headline.domain.model


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("code")
    val code: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)