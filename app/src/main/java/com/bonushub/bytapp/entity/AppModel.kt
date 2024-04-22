package com.bonushub.bytapp.entity

import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.helper.model.BaseCategoryProperty


@Entity(tableName = "app_model")
class AppModel : BaseCategoryProperty(), Cloneable {
    @SerializedName(value = "subcategories", alternate = ["children"])
    @Expose
    @Ignore
    var children: List<AppModel>? = null

    @Expose
    @Ignore
    var isChangePosition = false

    val otherProperty: OtherProperty?
        get() = getPropertyModel(object : TypeToken<OtherProperty?>() {})

    @Throws(CloneNotSupportedException::class)
    override fun clone(): Any {
        return super.clone()
    }

    val clone: AppModel
        get() = try {
            clone() as AppModel
        } catch (e: CloneNotSupportedException) {
            AppModel()
        }
}