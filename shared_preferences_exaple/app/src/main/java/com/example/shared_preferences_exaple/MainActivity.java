package com.example.shared_preferences_exaple;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView email_text_view,password_text_view;
    EditText user_name,password;
    Button log_in_btn;

    String text_user_name;
    String text_password;

    public static final String SharedPrefs = "SharedPrefs";
    public static final String Email = "Email";
    public static final String Password = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_text_view = findViewById(R.id.email_text_view);
        password_text_view = findViewById(R.id.password_text_view);
        user_name = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        log_in_btn =findViewById(R.id.log_in_btn);

        log_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();                                                                         //to save data to shared prefference
            }
        });

        loadData();
        if(savedInstanceState != null) {
            updateViews();
        }
    }
    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPrefs,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Email,user_name.getText().toString());
        editor.putString(Password,password.getText().toString());

        editor.apply();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show();
    }

    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPrefs,MODE_PRIVATE);
        text_user_name = sharedPreferences.getString(Email,"");
        text_password = sharedPreferences.getString(Password,"");
    }
    public void updateViews()
    {
        email_text_view.setText(text_user_name);
        password_text_view.setText(text_password);

    }
}

