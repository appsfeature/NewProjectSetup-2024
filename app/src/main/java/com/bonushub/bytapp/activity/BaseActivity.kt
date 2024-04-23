package com.bonushub.bytapp.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bonushub.bytapp.entity.ExtraProperty
import com.bonushub.bytapp.presenter.AppPresenter
import com.bonushub.bytapp.util.AppConstant


class BaseActivity : AppCompatActivity() {
    private var presenter: AppPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ViewModelProvider(this).get(AppPresenter::class.java)
        presenter?.initialize(intent)
    }


    fun getDefaultBundle(): Bundle {
        val bundle = Bundle()
        if (presenter?.categoryProperty != null) {
            val catProperty: ExtraProperty? = presenter?.categoryProperty?.getClone()
            bundle.putSerializable(AppConstant.CATEGORY_PROPERTY, catProperty)
        }
        return bundle
    }

    fun getCategoryProperty(): ExtraProperty? {
        return if (presenter?.categoryProperty != null) {
            presenter?.categoryProperty?.getClone()
        } else null
    }
}

