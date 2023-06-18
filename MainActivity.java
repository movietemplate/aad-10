package com.example.exp10_551;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName,etEmail,etPhone;
    private Button btnRegister,btnShow;
    private TextView tvResult;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnRegister = findViewById(R.id.btnRegister);
        btnShow = findViewById(R.id.btnShow);
        tvResult = findViewById(R.id.tvResult);
        databaseHelper=new DatabaseHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();


                // Insert data into the database
                databaseHelper.insertData(name, email,phone);

                etName.setText("");
                etEmail.setText("");
                etPhone.setText("");

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = databaseHelper.getData();
                tvResult.setText(data);
            }
        });
    }

}