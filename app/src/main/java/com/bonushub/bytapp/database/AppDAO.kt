package com.bonushub.bytapp.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bonushub.bytapp.entity.AppModel


@Dao
interface AppDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListRecords(list: List<AppModel>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOnlySingleRecord(record: AppModel): Long

    @Query("SELECT * FROM app_model order by ranking asc")
    fun fetchAllData(): List<AppModel>

    @Query("SELECT * FROM app_model where parent_id=:parentId order by ranking asc")
    fun fetchAllData(parentId: Int): List<AppModel>

    @Query("DELETE FROM app_model WHERE parent_id = :parentId")
    fun deleteByParentId(parentId: Int)
}