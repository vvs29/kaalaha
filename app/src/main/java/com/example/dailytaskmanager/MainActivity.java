package com.example.dailytaskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnDatePicker, btnTimePicker;
    EditText dateText, timeText;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (ImageButton) findViewById(R.id.dateButtonId);
        btnTimePicker = (ImageButton) findViewById(R.id.timeButtonId);
        dateText = (EditText) findViewById(R.id.dateDisplayId);
        timeText = (EditText) findViewById(R.id.timeDisplayId);

        Calendar c = Calendar.getInstance();
        dateText.setText(c.get(Calendar.DAY_OF_MONTH) +"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.YEAR));
        timeText.setText(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));

        btnTimePicker.setOnClickListener(this);
        btnDatePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == btnDatePicker) {
            final Calendar c = Calendar.getInstance();
            mDay = c.get(Calendar.DAY_OF_MONTH);
            mMonth = c.get(Calendar.MONTH);
            mYear = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dateText.setText(dayOfMonth + "-"+month+"-"+year);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();

        } else if (v == btnTimePicker) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timeText.setText(hourOfDay + ":" + minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }
    }
}
