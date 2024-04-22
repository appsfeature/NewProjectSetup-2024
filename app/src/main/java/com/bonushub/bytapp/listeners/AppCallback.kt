package com.bonushub.bytapp.listeners


interface AppCallback {
    interface OnNotificationReceived {
        fun onNotificationReceived()
    }

    interface Notification {
        fun onNotificationReceived(count: Int)
    }
}