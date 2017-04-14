package com.example.ebus.abkapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class BookingStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_status);


        final EditText etticketid = (EditText) findViewById(R.id.etticketid);

        Button bSearch = (Button) findViewById(R.id.bSearch);
        TextView update = (TextView) findViewById(R.id.update);
      final   CheckBox box1 = (CheckBox) findViewById(R.id.checkbox1);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Boolean boxchecked = box1.isChecked();
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


                                if (success) {

                                    yourResult(currl,desti,quantit,ticketp,returnusername,boxchecked,boxch);
                                    if(boxch.equals("true")){box1.setChecked(true);}else{box1.setChecked(false);}

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(BookingStatus.this);
                                    builder.setMessage("This is not your Ticket ID")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SearchRequestCL registerRequest = new SearchRequestCL(ticketid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BookingStatus.this);
                queue.add(registerRequest);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int ticketid = Integer.parseInt(etticketid.getText().toString());
                final Boolean boxchecked = box1.isChecked();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");




                            if (success) {
                               //Donothing


                            } else {
                                //Donothing
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Updatecheck registerRequest = new Updatecheck(ticketid,boxchecked, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BookingStatus.this);
                queue.add(registerRequest);
                AlertDialog.Builder builder = new AlertDialog.Builder(BookingStatus.this);
                builder.setMessage("Table Updated")
                        .setNegativeButton("Back", null)
                        .create()
                        .show();
            }
        });

    }



    private void yourResult(String current_l,String Destination,int quantity,int number,String username,Boolean box,String boxch) {
        TextView result1 = (TextView) findViewById(R.id.result);
if(boxch.equals("true")){
    result1.setText("Your Ticket \nUsername : "+ username+ "\nPerson Already Travelled on this Ticket ID" + "\nFrom "+current_l+" to "+Destination+" is : ₹ " + number + "\nYour Total number of Ticket is : "+ quantity);

}
        else{
    result1.setText("Your Ticket \nUsername : "+ username+ "\nPerson not yet Travelled on this Ticket ID" + "\nFrom "+current_l+" to "+Destination+" is : ₹ " + number + "\nYour Total number of Ticket is : "+ quantity);

}
    }
}
