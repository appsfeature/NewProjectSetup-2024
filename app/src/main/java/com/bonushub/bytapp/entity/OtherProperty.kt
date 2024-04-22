package com.bonushub.bytapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class OtherProperty : Serializable {
    @Expose
    @SerializedName(value = "update_id")
    var updateId: String? = null

    @Expose
    @SerializedName(value = "parent_id")
    var parentId = 0

    @Expose
    @SerializedName(value = "exam_id")
    var examId: IntArray? = null

    @Expose
    @SerializedName(value = "cat_id")
    var catId = 0

    @SerializedName(value = "is_sub_cat", alternate = ["isSubCat"])
    @Expose
    var isSubCat = true

    @SerializedName(value = "is_see_ans", alternate = ["isSeeAns"])
    @Expose
    var isSeeAns = true

    @SerializedName(value = "host")
    @Expose
    var host: String? = null
}

