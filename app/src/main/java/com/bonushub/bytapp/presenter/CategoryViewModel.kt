package com.bonushub.bytapp.presenter


import android.app.Activity
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.network.ApiConstants
import com.bonushub.bytapp.network.NetworkManager
import com.helper.callback.Response
import com.helper.callback.Response.CallbackImage
import com.helper.task.TaskRunner
import com.helper.util.BaseConstants


class CategoryViewModel(activity: Activity, callback: Response.Callback<AppModel>) {
    private var networkHandler: NetworkManager? = null
    private var callback: Response.Callback<AppModel>? = null
    var mCategoryId = 0
    var mChildrenLevel = 1
    private fun initialize(activity: Activity, callback: Response.Callback<AppModel>) {
        this.callback = callback
        networkHandler = getNetworkManager()
    }

    fun setCategoryId(mCategoryId: Int) {
        this.mCategoryId = mCategoryId
    }

    private fun getNetworkManager(): NetworkManager? {
        if (networkHandler == null) {
            networkHandler = NetworkManager()
        }
        return networkHandler
    }

    fun loadData() {
        isFirstHit = true
        fetchFromCache(null, null)
    }

    private fun fetchFromCache(imagePath: String?, catBeans: List<AppModel>?) {
        if (mCategoryId == 0) {
            callback!!.onFailure(Exception(BaseConstants.Error.MSG_ERROR))
            return
        }
//        TaskGetCategories(
//            mCategoryId,
//            imagePath,
//            catBeans
//        ).execute(TaskRunner.Callback<List<AppModel>?> { response ->
//            if (response != null && response.size > 0) {
//                updateLiveData(response)
//            } else {
//                if (!isFirstHit) {
//                    callback!!.onFailure(Exception(BaseConstants.NO_DATA))
//                }
//            }
//            if (isFirstHit) {
//                fetchDataFromServer()
//            }
//        })
    }

    private var isFirstHit = true

    init {
        initialize(activity, callback)
    }

    private fun fetchDataFromServer() {
//        networkHandler?.getSubCategories(
//            ApiConstants.GET_SUB_CATEGORIES,
//            mCategoryId,
//            mChildrenLevel,
//            object : CallbackImage<List<AppModel>?> {
//                override fun onSuccess(
//                    response: List<AppModel>?,
//                    imagePath: String,
//                    pdfPath: String
//                ) {
//                    isFirstHit = false
//                    fetchFromCache(imagePath, response)
//                }
//
//                override fun onFailure(e: Exception) {
//                    callback!!.onFailure(e)
//                }
//            })
    }

    private fun updateLiveData(list: List<AppModel>) {
        val examModel = AppModel()
        examModel.children = list
        callback!!.onSuccess(examModel)
    }
}