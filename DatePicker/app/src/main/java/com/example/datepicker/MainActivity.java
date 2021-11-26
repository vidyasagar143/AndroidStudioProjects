package com.example.datepicker;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but=(Button)findViewById(R.id.button);
      but.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              DialogFragment datepicker=new DatePickerFragment();
              datepicker.show(getSupportFragmentManager(),"date picker");
          }
      });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        c.set(Calendar.MONTH,month);
        String currntDateString= DateFormat.getDateInstance().format(c.getTime());
        TextView v1=(TextView)findViewById(R.id.textView);
        v1.setText(currntDateString);
    }
}
