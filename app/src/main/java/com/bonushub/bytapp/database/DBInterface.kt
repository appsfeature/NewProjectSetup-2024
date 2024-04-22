package com.bonushub.bytapp.database

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.entity.Notification


interface DBInterface {
    fun deleteAppDataByParentId(parentId: Int)
    fun insertAppDataList(list: List<AppModel>): List<Long>
    fun fetchAppData(categoryId: Int): List<AppModel>
    fun fetchNotificationCount(owner: LifecycleOwner, observer: Observer<Int>)
    fun fetchNotificationData(owner: LifecycleOwner, observer: Observer<List<Notification>>)
    fun deleteNotification(uuid: String)
    fun insertNotificationTest()
    fun insertNotification(notification: Notification)
    fun hasReadNotification(uuid: String)
    fun isNotificationExist(uuid: String): Boolean
}

