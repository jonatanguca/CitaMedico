package com.android.curso.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TextView tvHora;
    private TextView tvFecha;
    private EditText edtNombre;
    private RadioGroup bgOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHora = (TextView) findViewById(R.id.tvHora);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        bgOpciones = (RadioGroup) findViewById(R.id.bgOpciones);
    }

    public void fecha(View v) {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int day) {
                tvFecha.setText(day + "-" + (monthOfYear + 1) + "-" + "" + year);
            }
        }, 2017, 8/*siempre un mes menos del "real"*/, 25).show();
    }

    public void hora(View v) {
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                tvHora.setText(String.format("%02d:%02d", hora, minuto));
            }
        }, 10, 0, true).show();
        // los minutos entre el 0 y el 9, se ponen con UN sólo dígito, no se pone 00-09
    }

    public void citar(View v) {

        Intent intent = new Intent(this, ConfirmacionActivity.class);
        intent.putExtra("nombre", edtNombre.getText().toString());
        intent.putExtra("fecha", tvFecha.getText().toString());
        intent.putExtra("hora", tvHora.getText().toString());
        int res = bgOpciones.getCheckedRadioButtonId();
        switch (res) {
            case R.id.rbtnMedicinaGeneral:
                intent.putExtra("tipo", getResources().getString(R.string.medicinageneral));
                break;
            case R.id.rbtnPediatria:
                intent.putExtra("tipo", getResources().getString(R.string.pediatria));
                break;
        }
        startActivity(intent);
    }
}
