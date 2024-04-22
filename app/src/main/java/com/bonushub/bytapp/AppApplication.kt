package com.bonushub.bytapp


import android.app.Activity
import android.os.Bundle
import com.bonushub.bytapp.database.AppDatabase
import com.bonushub.bytapp.database.DBInterface
import com.bonushub.bytapp.network.ApiConstants
import com.configlite.ConfigManager
import com.configlite.type.ApiHost
import com.helper.application.ActivityLifecycleObserver
import com.helper.application.BaseApplication
import com.helper.callback.ActivityLifecycleListener
import com.squareup.picasso.Picasso


class AppApplication : BaseApplication() {
    private var appDatabase: DBInterface? = null

    fun getAppDatabase(): DBInterface {
        if (appDatabase == null) {
            appDatabase = AppDatabase.getInstance()
        }
        return appDatabase!!
    }


    companion object {
        fun getInstance(): AppApplication {
            return instance!!
        }

        private var instance: AppApplication? = null
    }

    private var configManager: ConfigManager? = null

    fun getConfigManager(): ConfigManager {
        if (configManager == null) {
            configManager = ConfigManager.getInstance()
                .setEnableDebugMode(BuildConfig.DEBUG)
                .setEnableSecurityCode(getInstance())
                .addHostUrl(ApiHost.HOST_DEFAULT, ApiConstants.BASE_URL)
        }
        return configManager!!
    }


    override fun isDebugMode(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ActivityLifecycleObserver.getInstance().register(this)
    }

    override fun initLibs() {
        if (!isLoaded) {
            configManager = getConfigManager()
            setEnableCurrentActivityLifecycle(true)
            addActivityLifecycleListener(hashCode(), object : ActivityLifecycleListener {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
                override fun onActivityResumed(activity: Activity) {
                    currentActivity = activity
                }
            })
            isLoaded = true
        }
    }


    var currentActivity: Activity? = null

    val picasso: Picasso
        get() = Picasso.get()

}
