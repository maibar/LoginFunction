package com.example.lenovo.lockmagicdoor;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnInteractionInterface{

    private EditText Username;
    private EditText Password;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment fragment = HomeFragment.newInstance("param1", "param2");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_display, fragment);
        transaction.commit();
        //LoginButton();
    }

    public void LoginButton(){
        Username = (EditText)findViewById(R.id.et_username);
        Password = (EditText)findViewById(R.id.et_password);
        Login = (Button)findViewById(R.id.login);

        Login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Username.getText().toString().equals("user") &&
                        Password.getText().toString().equals("pass"))
                        {
                            DashboardFragment fragment = DashboardFragment.newInstance("param1", "param2");
                            FragmentManager manager = getSupportFragmentManager();
                            FragmentTransaction transaction = manager.beginTransaction();
                            transaction.add(R.id.main_display, fragment);
                            transaction.commit();

                        }else
                        {
                            counter--;
                            if (counter==0){
                                Login.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }

    @Override
    public void OnInteractionInterface() {

    }
}
