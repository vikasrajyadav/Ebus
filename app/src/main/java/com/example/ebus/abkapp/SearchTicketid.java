package com.example.ebus.abkapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchTicketid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ticketid);
        Intent intent = getIntent();
        final int balance = intent.getIntExtra("balance",-1);
     final String username = intent.getStringExtra("username");

        final EditText etticketid = (EditText) findViewById(R.id.etticketid);

        TextView bSearch = (TextView) findViewById(R.id.bSearch);
        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int ticketid = Integer.parseInt(etticketid.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            String returnusername = jsonResponse.getString("username");
                            String currl = jsonResponse.getString("current_l");
                            String desti = jsonResponse.getString("destination");
                            int quantit = jsonResponse.getInt("quantity");
                            int ticketp = jsonResponse.getInt("ticketprice");
                            String boxch = jsonResponse.getString("boole");

                             if(returnusername.equals(username)){
                            if (success) {

                                yourResult(currl,desti,quantit,ticketp,boxch);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SearchTicketid.this);
                                builder.setMessage("This is not your Ticket ID")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }}
                            else{AlertDialog.Builder builder = new AlertDialog.Builder(SearchTicketid.this);
                                 builder.setMessage("This is not your Ticket ID \nPlease Enter Your Ticket ID")
                                         .setNegativeButton("Retry", null)
                                         .create()
                                         .show();}
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SearchRequest registerRequest = new SearchRequest(ticketid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SearchTicketid.this);
                queue.add(registerRequest);
            }
        });

    }



    private void yourResult(String current_l,String Destination,int quantity,int number,String boxch) {
        TextView result1 = (TextView) findViewById(R.id.result);
        if(boxch.equals("true")){
        result1.setText("Your Ticket\n"+"You have Travelled on this Ticket ID" + "\nFrom "+current_l+" to "+Destination+" is ₹ " + number + "\nYour Total number of Ticket is : "+ quantity);
    }else{        result1.setText("Your Ticket\n"+"You haven't Travelled yet  on this Ticket ID" + "\nFrom "+current_l+" to "+Destination+" is ₹ " + number + "\nYour Total number of Ticket is : "+ quantity);
        }}
}
