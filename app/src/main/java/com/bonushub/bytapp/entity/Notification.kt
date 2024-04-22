package com.bonushub.bytapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notification")
class Notification {
    var id = 0

    @PrimaryKey
    var uuid = ""
    var notificationId = 0
    var title: String? = null
    var body: String? = null
    var type = 0
    var jsonData: String? = null
    var updatedAt: String? = null
    var hasRead = 0

    fun isHasRead(): Boolean {
        return hasRead == 1
    }
}