package com.csci448.jaidynnfohr.alpha_release.util
//
//import android.annotation.SuppressLint
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.graphics.Color
//import android.location.Location
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import com.csci448.jaidynnfohr.alpha_release.MainActivity
//import com.csci448.jaidynnfohr.alpha_release.R
//
//object LocationNotificationUtility {
//    @SuppressLint("StringFormatMatches")
//    fun pushNotification(context: Context, location: Location){
//        val channelId = "NoSadchannelID"
//        val channelName = context.resources.getString(R.string.app_name)
//        val channelDesc = context.resources.getString(R.string.notification_channel_desc)
//
//        val notificationChannel = NotificationChannel(
//            channelId,channelName, NotificationManager.IMPORTANCE_DEFAULT
//        ).apply {
//            description = channelDesc
//            enableLights(true)
//            lightColor = Color.BLUE
//            setShowBadge(true)
//        }
//
//        val notificationManager = NotificationManagerCompat.from(context)
//        notificationManager.createNotificationChannel(notificationChannel)
//        val pendingIntent = MainActivity.createPendingIntent(context = context, location = location)
//
//        val notification = NotificationCompat.Builder(context,channelId)
//            .setSmallIcon(android.R.drawable.ic_dialog_map)
//            .setContentTitle(context.resources.getString(R.string.notification_title))
//            .setContentText(context.resources.getString(R.string.notification_content_text,location.latitude,location.longitude))
//            .setAutoCancel(true)
//            .setContentIntent(pendingIntent)
//            .build()
//
//        notificationManager.notify(0,notification)
//    }
//}