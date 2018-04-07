package com.example.charl.alarm_clock;

import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private Button B;

    private EditText A;
    private EditText C;
    private EditText Info;

    String D;
    String E;
    String Inf;


    private Integer Num1;
    private Integer Num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B = findViewById(R.id.Alarm);

        B.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                A= findViewById(R.id.Minutes);
                C= findViewById(R.id.Hour);
                Info= findViewById(R.id.Info);

                D= A.getText().toString();
                E= C.getText().toString();
                Inf= Info.getText().toString();

                if(!D.isEmpty() & !E.isEmpty() & !Inf.isEmpty() ) {

                    Num1 = Integer.parseInt(A.getText().toString());
                    Num2 = Integer.parseInt(C.getText().toString());

                    if (Num1 >= 0 & Num1 <= 59) {
                        if (Num2 >= 0 & Num2 <= 23) {

                          createAlarm(Inf,Num2,Num1);
                        }
                    }
                }

            }
        });

    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }




}
