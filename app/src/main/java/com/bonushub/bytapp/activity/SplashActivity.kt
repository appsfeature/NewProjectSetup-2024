package com.bonushub.bytapp.activity


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bonushub.bytapp.AppApplication
import com.bonushub.bytapp.util.AppPreferences


class SplashActivity : AppCompatActivity() {
    private val mDelayTime = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        AppApplication.getInstance().init()
        super.onCreate(savedInstanceState)
        openHomeActivity()
    }

    private fun openHomeActivity() {
        Handler().postDelayed({ openMainActivity() }, mDelayTime.toLong())
    }

    private fun openMainActivity() {
        val intent = getPreviousIntent()
        if (AppPreferences.getSelectedClassId() == 0) {
//            intent.setClass(this, ClassSelectionActivity::class.java)
//            intent.putExtra(AppConstant.IS_OPEN_MAIN_ACTIVITY, true)
        } else {
            intent.setClass(this, MainActivity::class.java)
            intent.putExtras(getIntent())
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finishClass()
    }

    private fun finishClass() {
        try {
            Handler().postDelayed({ finishAffinity() }, 500)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getPreviousIntent(): Intent {
        return if (intent == null) Intent() else intent
    }
}

