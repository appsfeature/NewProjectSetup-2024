package com.bonushub.bytapp.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import com.bonushub.bytapp.AppApplication
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.entity.CommonModel
import com.bonushub.bytapp.entity.Notification


@Database(
    entities = [CommonModel::class, Notification::class, AppModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : DBManager() {
    abstract fun commonDAO(): CommonDAO
    abstract fun appDAO(): AppDAO
    abstract fun notificationDAO(): NotificationDAO

    companion object {
        private const val DB_NAME = "bytapp-db"
        private var appDatabase: AppDatabase? = null

        fun create(context: Context?): AppDatabase {
            return databaseBuilder(context!!, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

        fun getInstance(): AppDatabase {
            if (appDatabase == null) appDatabase = create(AppApplication.getInstance())
            return appDatabase!!
        }
    }
}