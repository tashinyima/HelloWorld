package com.example.helloworld.product.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discountPercentage")
    val discountPercentage: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble()!!,
        parcel.readInt(),
        parcel.createStringArrayList()!!,
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeDouble(discountPercentage)
        parcel.writeInt(id)
        parcel.writeStringList(images)
        parcel.writeInt(price)
        parcel.writeDouble(rating)
        parcel.writeInt(stock)
        parcel.writeString(thumbnail)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}