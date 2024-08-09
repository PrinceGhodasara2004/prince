package com.example.prince;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    EditText edttxt_name, edttxt_email, edttxt_mobile, edttxt_regisPass, edttxt_confirmPass;
    Button register_btn;
    RadioButton radiobtn_male,radiobtn_female;


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        edttxt_name = findViewById(R.id.edttxt_name);
        edttxt_email = findViewById(R.id.edttxt_email);
        edttxt_mobile = findViewById(R.id.edttxt_mobile);
        edttxt_regisPass = findViewById(R.id.edttxt_regisPass);
        edttxt_confirmPass = findViewById(R.id.edttxt_confirmPass);
        register_btn = findViewById(R.id.register_btn);
        radiobtn_male = findViewById(R.id.radiobtn_male);
        radiobtn_female = findViewById(R.id.radiobtn_female);



        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edttxt_name.getText().toString().trim().equals("")){
                    edttxt_name.setError("Please Enter Your Name");
                } else if (!edttxt_email.getText().toString().trim().matches(emailPattern)) {
                    edttxt_email.setError("Email ID Invalid");
                } else if (edttxt_mobile.getText().toString().trim().equals("")) {
                    edttxt_mobile.setError("Please Enter Your Phone Number");
                } else if (edttxt_mobile.getText().toString().trim().length()<10) {
                    edttxt_mobile.setError("Phone Number Invalid");
                } else if (edttxt_regisPass.getText().toString().trim().length()<6) {
                    edttxt_regisPass.setError("Minimum 6 Character Required");
                } else if (edttxt_confirmPass.getText().toString().trim().length()<6) {
                    edttxt_confirmPass.setError("Minimum 6 Character Required");
                } else {
                    new ToastCommonMethod(Registration.this,"Register Successfully");
                    Intent intent = new Intent(Registration.this, RegisterSuccess.class);
                    startActivity(intent);
                }
            }
        });

        radiobtn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ToastCommonMethod(Registration.this, "Male");
            }
        });

        radiobtn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ToastCommonMethod(Registration.this, "Female");
            }
        });


    }
}