package com.bonushub.bytapp.presenter


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.bonushub.bytapp.entity.ExtraProperty
import com.bonushub.bytapp.util.AppConstant


class AppPresenter : ViewModel() {
    var categoryProperty: ExtraProperty? = null
        private set

    fun initialize(intent: Intent?) {
        if (intent != null && intent.getSerializableExtra(AppConstant.CATEGORY_PROPERTY) is ExtraProperty) {
            categoryProperty =
                intent.getSerializableExtra(AppConstant.CATEGORY_PROPERTY) as ExtraProperty?
        }
    }

    fun initialize(bundle: Bundle?) {
        if (bundle != null && bundle.getSerializable(AppConstant.CATEGORY_PROPERTY) is ExtraProperty) {
            categoryProperty =
                bundle.getSerializable(AppConstant.CATEGORY_PROPERTY) as ExtraProperty?
        }
    }
}