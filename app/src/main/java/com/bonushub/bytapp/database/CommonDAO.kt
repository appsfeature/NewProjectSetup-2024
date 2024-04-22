package com.bonushub.bytapp.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bonushub.bytapp.entity.CommonModel


@Dao
interface CommonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListRecords(list: List<CommonModel>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOnlySingleRecord(record: CommonModel): Long

    @Query("SELECT * FROM common_data order by updated_at desc LIMIT 3")
    fun fetchHomeAnnouncements(): List<CommonModel>

    @get:Query("SELECT id FROM common_data order by updated_at desc LIMIT 1")
    val maxContentId: Int

    @Query("SELECT * FROM common_data order by updated_at desc")
    fun fetchAllData(): LiveData<List<CommonModel>>

    @get:Query("SELECT COUNT(*) FROM common_data where has_read=0")
    val count: LiveData<Int>

    @get:Query("SELECT id FROM common_data where has_read=1")
    val hasReadList: List<Int>

    @Query("UPDATE common_data SET has_read='1' WHERE id=:contentId")
    fun setHasRead(contentId: Int): Int
}