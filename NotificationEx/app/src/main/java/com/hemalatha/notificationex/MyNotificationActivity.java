package com.hemalatha.notificationex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyNotificationActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);
        editText=findViewById(R.id.editText);

    }

    public void send(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
