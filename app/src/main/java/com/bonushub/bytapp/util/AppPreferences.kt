package com.bonushub.bytapp.util


import com.bonushub.bytapp.AppApplication
import com.helper.util.BasePrefUtil


object AppPreferences : BasePrefUtil() {
    private const val SELECTED_CLASS_ID = "selected_class_id"
    private const val SELECTED_CLASS_NAME = "selected_class_name"

    fun getSelectedClassId(): Int {
        return getInt(AppApplication.getInstance(), SELECTED_CLASS_ID, 0)
    }

    fun setSelectedClassId(value: Int) {
        setInt(AppApplication.getInstance(), SELECTED_CLASS_ID, value)
    }

    fun getSelectedClassName(): String {
        return getString(AppApplication.getInstance(), SELECTED_CLASS_ID, "")
    }

    fun setSelectedClassName(value: String) {
        setString(AppApplication.getInstance(), SELECTED_CLASS_NAME, value)
    }
}