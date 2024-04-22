package com.bonushub.bytapp.network


import android.content.Context
import com.bonushub.bytapp.AppApplication
import com.bonushub.bytapp.database.DBInterface
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.entity.CommonModel
import com.configlite.BaseNetworkManager
import com.configlite.type.ApiHost
import com.helper.callback.Response


class NetworkManager() : BaseNetworkManager(AppApplication.getInstance().getConfigManager()) {
    private val dbManager: DBInterface
    private val host: String = ApiHost.HOST_MAIN

    init {
        dbManager = AppApplication.getInstance().getAppDatabase()
    }

    fun fetchAnnouncements(
        context: Context?,
        maxContentId: Int,
        callback: Response.Callback<List<CommonModel>>
    ) {

    }

    fun getSubCategories(
        methodName: String?,
        categoryId: Int,
        childrenLevel: Int,
        callback: Response.Callback<List<AppModel>>
    ) {

    }
}