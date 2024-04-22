package com.bonushub.bytapp.entity

import com.helper.model.BaseCategoryProperty
import java.io.Serializable


class ExtraProperty : BaseCategoryProperty(), Serializable, Cloneable {
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        return super.clone()
    }

    val clone: ExtraProperty
        get() = try {
            clone() as ExtraProperty
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
            ExtraProperty()
        }
}
