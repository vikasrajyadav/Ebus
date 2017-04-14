package com.example.ebus.abkapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String username1 = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
       final int balance = intent.getIntExtra("balance",-1);


        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        EditText etAge = (EditText) findViewById(R.id.etAge);
        TextView tvBook = (TextView) findViewById(R.id.textView23);
        TextView tvbalance = (TextView)findViewById(R.id.textView24);
        TextView ticketsearch = (TextView)findViewById(R.id.ticketsearch);


        // Display user details
        String message = " Welcome " + name;
        tvWelcomeMsg.setText(message);
        etUsername.setText(username1);
        etAge.setText(age + "");
        tvbalance.setText("Balance: ₹ " + balance);
        tvBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserActivity.this, TBooking.class);
                registerIntent.putExtra("username", username1);
                registerIntent.putExtra("balance",balance);
                UserActivity.this.startActivity(registerIntent);
            }
        });

        ticketsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserActivity.this, SearchTicketid.class);
                registerIntent.putExtra("username", username1);
                registerIntent.putExtra("balance",balance);
                UserActivity.this.startActivity(registerIntent);
            }
        });

    }

}
