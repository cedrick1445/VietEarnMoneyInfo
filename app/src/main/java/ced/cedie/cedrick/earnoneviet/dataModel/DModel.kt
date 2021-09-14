package ced.cedie.cedrick.earnoneviet.dataModel

import com.google.gson.annotations.SerializedName

data class DModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("descriptions")
    val descriptions: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String,

)