package com.example.dailytaskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

public class TimeLoggerActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnDatePicker, btnTimePicker;
    EditText dateText, timeText;
    LocalDateTime currentDateTime;
    LocalDate today;
    LocalTime time_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timelogger);

        btnDatePicker = (ImageButton) findViewById(R.id.timeLoggerDateButtonId);
        btnTimePicker = (ImageButton) findViewById(R.id.timeLoggerTimeButtonId);
        dateText = (EditText) findViewById(R.id.timeLoggerDateDisplayId);
        timeText = (EditText) findViewById(R.id.timeLoggerTimeDisplayId);

        dateText.setEnabled(false);
        timeText.setEnabled(false);

        currentDateTime = LocalDateTime.now();
        today = currentDateTime.toLocalDate();
        time_now = currentDateTime.toLocalTime();

        dateText.setText(today.getDayOfMonth()+"-"+today.getMonthValue()+"-"+today.getYear());
        timeText.setText(time_now.getHour()+":"+time_now.getMinute());

        btnTimePicker.setOnClickListener(this);
        btnDatePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == btnDatePicker) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dateText.setText(dayOfMonth + "-"+month+"-"+year);
                }
            },today.getYear(),today.getMonthValue(),today.getDayOfMonth());
            datePickerDialog.show();

        } else if (v == btnTimePicker) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timeText.setText(hourOfDay + ":" + minute);
                }
            },time_now.getHour(),time_now.getMinute(),false);
            timePickerDialog.show();
        }
    }
}
