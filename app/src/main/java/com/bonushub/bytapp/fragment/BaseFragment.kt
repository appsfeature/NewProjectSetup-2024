package com.bonushub.bytapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bonushub.bytapp.entity.ExtraProperty
import com.bonushub.bytapp.presenter.AppPresenter
import com.bonushub.bytapp.util.AppConstant


class BaseFragment : Fragment() {
    private var presenter: AppPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ViewModelProvider(requireActivity()).get(AppPresenter::class.java)
        presenter?.initialize(arguments)
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

    fun getProperty(): ExtraProperty? {
        return if (getCategoryProperty() == null) {
            ExtraProperty()
        } else getCategoryProperty()
    }
}

