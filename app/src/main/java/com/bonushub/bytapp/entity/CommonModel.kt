package com.bonushub.bytapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "common_data")
class CommonModel  {
    constructor()
    constructor(id: Int, title: String?, dateTime: String?) {
        this.id = id
        this.title = title
        updatedAt = dateTime
    }

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id = 0

    @SerializedName("item_type")
    @Expose
    @ColumnInfo(name = "item_type")
    var itemType = 0

    @SerializedName("type")
    @Expose
    @ColumnInfo(name = "type")
    var type = 0

    @SerializedName("category_id")
    @Expose
    @ColumnInfo(name = "category_id")
    var categoryId = 0

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    var title: String? = null

    @SerializedName("created_at")
    @Expose
    @ColumnInfo(name = "created_at")
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = null

    @SerializedName("app_id_android")
    @Expose
    @ColumnInfo(name = "app_id_android")
    var apIdAndroid: String? = null

    @SerializedName("app_id_ios")
    @Expose
    @ColumnInfo(name = "app_id_ios")
    var appIdIos: String? = null

    @SerializedName("web_url")
    @Expose
    @ColumnInfo(name = "web_url")
    var webUrl: String? = null

    @SerializedName("pdf_link")
    @Expose
    @ColumnInfo(name = "pdf_link")
    var pdfLink: String? = null

    @ColumnInfo(name = "has_read")
    var isHasRead = false

    @Ignore
    var jsonData: String? = null

    @Ignore
    var description: String? = null

    @Ignore
    var uuid: String? = null
}

