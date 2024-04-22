package com.bonushub.bytapp.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bonushub.bytapp.entity.Notification


@Dao
interface NotificationDAO {
    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    fun insertOnlySingleRecord(notificationModel: Notification): Long?

    @Query("SELECT * FROM notification order by updatedAt desc LIMIT 2000")
    fun fetchAllData(): LiveData<List<Notification>>

    @Query("SELECT * FROM notification WHERE uuid=:uuid LIMIT 1")
    fun isExist(uuid: String): Notification?

    @Query("SELECT * FROM notification where hasRead=0")
    fun getUnReadNotification() : List<Notification>

    @Query("SELECT COUNT(*) FROM notification where hasRead=0")
    fun getCount() : LiveData<Int>

    @Query("DELETE FROM notification where id=:notificationId")
    fun deleteRecord(notificationId: Int): Int

    @Query("DELETE FROM notification where uuid=:uuid")
    fun deleteRecord(uuid: String): Int

    @Query("UPDATE notification SET hasRead=1 WHERE notificationId=:notificationId")
    fun setHasRead(notificationId: Int): Int

    @Query("UPDATE notification SET hasRead=1 WHERE uuid=:notificationId")
    fun setHasRead(notificationId: String): Int
}