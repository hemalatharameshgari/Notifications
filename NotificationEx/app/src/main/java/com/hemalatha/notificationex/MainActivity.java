package com.hemalatha.notificationex;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder builder;
    NotificationManager notificationManager;
    PendingIntent pendingIntent;
    NotificationHelperChannel helperChannel;
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helperChannel =new NotificationHelperChannel(this);

        notificationManager= (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notificationcall(View view) {
        Notification.Builder builder=helperChannel.getNotificationChannel();
        helperChannel.notificationManager.notify(8,builder.build());

        /*pendingIntent= PendingIntent.
                getActivity
                        (this,123,intent,
                                PendingIntent.FLAG_UPDATE_CURRENT);*/
       /* builder=new NotificationCompat.Builder(this)
                    .setContentTitle("APSSDC")
                    .setContentText("hello")
                    .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                    .setContentIntent(pendingIntent)
                    .addAction(R.drawable.ic_trending_flat_black_24dp,
                            getString(R.string.reply),pendingIntent);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.rekha);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        Notification notification=new Notification();
        notificationManager.notify(123,notification);*/
    }
}
