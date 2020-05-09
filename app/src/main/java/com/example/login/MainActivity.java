package com.example.login;
//Reference: https://www.google.com/search?q=login+screen+in+android+studio&oq=login+screen+in+android+s&aqs=chrome.0.
// 0j69i57j69i60l2.19485j0j8&sourceid=chrome&ie=UTF-8#kpvalbx=_B461XsfqO4KCytMPpLW9oAM57

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.buttonLogin);

        Info.setText("Number of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName == "VijiSar") && (userPassword == "3456")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;
            Info.setText("Number of attempts remaining: " + String.valueOf(counter)) ;

            if (counter == 0) {
                Login.setEnabled(false);

            }
        }

    }
}
