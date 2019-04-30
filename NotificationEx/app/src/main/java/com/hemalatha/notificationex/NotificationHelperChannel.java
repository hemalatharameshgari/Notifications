package com.hemalatha.notificationex;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class NotificationHelperChannel extends ContextWrapper {
    NotificationManager notificationManager;
    PendingIntent pendingIntent;
    Intent intent;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelperChannel(Context base) {
        super(base);
        createChannel();
        intent=new Intent(base,MyNotificationActivity.class);
        pendingIntent=PendingIntent.getActivity(base,76,intent,PendingIntent.FLAG_UPDATE_CURRENT);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannel(){
        NotificationChannel channel=new
                NotificationChannel("123","channel",
                NotificationManager.IMPORTANCE_HIGH);
                channel.enableLights(true);
                channel.enableVibration(true);
                channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                channel.setLightColor(Color.DKGRAY);
       // notificationManager.createNotificationChannel(channel);
        getNotificationManager().createNotificationChannel(channel);

    }
    private NotificationManager getNotificationManager(){
        if(notificationManager==null)
            notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        return notificationManager;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getNotificationChannel(){
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.rekha);

        return new Notification.Builder(getApplicationContext(),"123")
                .setContentText("Oreo Notification")
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentTitle("MOM msg")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setBadgeIconType(R.drawable.rekha)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_trending_flat_black_24dp,
                        getString(R.string.reply),pendingIntent)
                .setStyle(new Notification.BigPictureStyle().bigPicture(bitmap));
       // builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
    }
}
