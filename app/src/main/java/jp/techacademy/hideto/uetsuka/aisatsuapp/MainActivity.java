package jp.techacademy.hideto.uetsuka.aisatsuapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private  Calendar calendar;
    private int hour;
    private int minute;
    private final static String MORNING = "おはよう";
    private final static String AFTERNOON = "こんにちは";
    private final static String EVENING = "こんばんは";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void greet(View v){
        String greetingMessage;
        TextView textView =  (TextView)findViewById(R.id.greeting);
        if(hour >= 2 && hour < 10){
            greetingMessage = MORNING;
        }else if(hour >= 10 && hour < 18){
            greetingMessage = AFTERNOON;
        }else{
            greetingMessage = EVENING;
        }
        textView.setText(greetingMessage);
    }

    public void timeSet(View v){
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        MainActivity.this.hour = hourOfDay;
                        MainActivity.this.minute = minute;
                    }
                },
                MainActivity.this.hour,
                MainActivity.this.minute,
        true);
        timePickerDialog.show();
    }
}
