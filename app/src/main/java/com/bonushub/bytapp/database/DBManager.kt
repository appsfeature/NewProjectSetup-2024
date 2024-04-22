package com.bonushub.bytapp.database


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.room.RoomDatabase
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.entity.Notification
import com.helper.task.TaskRunner
import com.helper.util.BaseUtil
import java.util.concurrent.Callable


abstract class DBManager : RoomDatabase(), DBInterface {
    override fun fetchAppData(categoryId: Int): List<AppModel> {
        return AppDatabase.getInstance().appDAO().fetchAllData(categoryId)
    }

    override fun deleteAppDataByParentId(parentId: Int) {
        AppDatabase.getInstance().appDAO().deleteByParentId(parentId)
    }

    override fun insertAppDataList(list: List<AppModel>): List<Long> {
        return AppDatabase.getInstance().appDAO().insertListRecords(list)
    }

    override fun fetchNotificationCount(owner: LifecycleOwner, observer: Observer<Int>) {
        AppDatabase.getInstance().notificationDAO().getCount().observe(owner, observer)
    }

    override fun fetchNotificationData(owner: LifecycleOwner, observer: Observer<List<Notification>>) {
        AppDatabase.getInstance().notificationDAO().fetchAllData().observe(owner, observer)
    }

    override fun deleteNotification(uuid: String) {
        AppDatabase.getInstance().notificationDAO().deleteRecord(uuid)
    }

    override fun insertNotificationTest() {
        val notification = Notification()
        notification.uuid = (System.currentTimeMillis().toString() + "")
        notification.title = ("Notification " + BaseUtil.getDatabaseTimeStamp())
        notification.updatedAt = (BaseUtil.getDatabaseTimeStamp())
        insertNotification(notification)
    }

    override fun insertNotification(notification: Notification) {
        AppDatabase.getInstance().notificationDAO().insertOnlySingleRecord(notification)
    }

    override fun hasReadNotification(uuid: String) {
        TaskRunner.getInstance().executeAsync<Any>(Callable<Any> {
            AppDatabase.getInstance().notificationDAO().setHasRead(uuid)
        })
    }

    override fun isNotificationExist(uuid: String): Boolean {
        val notification: Notification? = AppDatabase.getInstance().notificationDAO().isExist(uuid)
        return notification != null
    }
}

