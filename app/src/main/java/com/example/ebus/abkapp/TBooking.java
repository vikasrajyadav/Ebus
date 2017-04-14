package com.example.ebus.abkapp;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This app displays an order form to order coffee.
 */
public class TBooking extends AppCompatActivity {


    int quantity = 1;
    int balance4 ;
   int price2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbooking);
        Intent intent = getIntent();
       final int balance = intent.getIntExtra("balance",-1);
      String username = intent.getStringExtra("username");
        display3(username);
        display4(balance);
        wallet(balance);


    }
private int wallet(int money){
    balance4 = money;
    return balance4;
}
    /**
     * This method is called when the order button is clicked.
     */
    public void checkPrice(View view){
        EditText edit = (EditText) findViewById(R.id.current_location);
        String current_l = edit.getText().toString();

        EditText edit1 = (EditText) findViewById(R.id.destination);
        String Desti = edit1.getText().toString();
        if (current_l.equals("Thane") || current_l.equals("thane")) {
            if (Desti.equals("Airoli") || Desti.equals("airoli")) {
                price2 = 10;
                buttonprice(current_l,Desti,price2);
            } else if (Desti.equals("Kalwa") || Desti.equals("kalwa")) {
                price2 = 15;
                buttonprice(current_l,Desti,price2);

            } else if (Desti.equals("Mulund") || Desti.equals("mulund")) {
                price2 = 20;
                buttonprice(current_l,Desti,price2);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Desti + "\nOR\n" + "Your Spelling is incorrect")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
        } else if (current_l.equals("Kalwa") || current_l.equals("kalwa")) {
            if (Desti.equals("Airoli") || Desti.equals("airoli")) {
                price2 = 5;
                buttonprice(current_l,Desti,price2);

            } else if (Desti.equals("Thane") || Desti.equals("thane")) {
                price2 = 10;
                buttonprice(current_l,Desti,price2);

            } else if (Desti.equals("Mulund") || Desti.equals("mulund")) {
                price2 = 15;
                buttonprice(current_l,Desti,price2);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Desti + "\nOR\n" + "Your Spelling is incorrect")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }

        } else if (current_l.equals("Airoli") || current_l.equals("airoli")) {
            if (Desti.equals("Thane") || Desti.equals("Thane")) {
                price2 = 5;
                buttonprice(current_l,Desti,price2);

            } else if (Desti.equals("Thane") || Desti.equals("thane")) {
                price2 = 10;
                buttonprice(current_l,Desti,price2);

            } else if (Desti.equals("Mulund") || Desti.equals("mulund")) {
                price2 = 15;
                buttonprice(current_l,Desti,price2);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Desti + "\nOR\n" + "Your Spelling is incorrect")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
            builder.setMessage("We are not located in " + current_l + "\nOR\n" + "Your Spelling is incorrect")
                    .setNegativeButton("Retry", null)
                    .create()
                    .show();
        }
    }

    public void submitOrder(View view) {
        EditText edit = (EditText) findViewById(R.id.current_location);
        String current_location = edit.getText().toString();

        EditText edit1 = (EditText) findViewById(R.id.destination);
        String Destination = edit1.getText().toString();
        if (current_location.equals("Thane") || current_location.equals("thane")) {
            if (Destination.equals("Airoli") || Destination.equals("airoli")) {
                price2 = 10;
                call();
                button(current_location,Destination);
            } else if (Destination.equals("Kalwa") || Destination.equals("kalwa")) {
                price2 = 15;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Mulund") || Destination.equals("mulund")) {
                price2 = 20;
                call();
                button(current_location,Destination);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Destination +"\nOR\n"+"Your Spelling is incorrect" + "\nPlease Select from following location 'Thane, Mulund, Airoli, Kalwa' ")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
        } else if (current_location.equals("Kalwa") || current_location.equals("kalwa")) {
            if (Destination.equals("Airoli") || Destination.equals("airoli")) {
                price2 = 5;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Thane") || Destination.equals("thane")) {
                price2 = 10;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Mulund") || Destination.equals("mulund")) {
                price2 = 15;
                call();
                button(current_location,Destination);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Destination +"\nOR\n"+"Your Spelling is incorrect" + "\nPlease Select from following location 'Thane, Mulund, Airoli, Kalwa' ")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }

        } else if (current_location.equals("Airoli") || current_location.equals("airoli")) {
            if (Destination.equals("Thane") || Destination.equals("Thane")) {
                price2 = 5;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Thane") || Destination.equals("thane")) {
                price2 = 10;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Mulund") || Destination.equals("mulund")) {
                price2 = 15;
                call();
                button(current_location,Destination);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Destination +"\nOR\n"+"Your Spelling is incorrect" + "\nPlease Select from following location 'Thane, Mulund, Airoli, Kalwa' ")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }

        }
        else if (current_location.equals("Mulund") || current_location.equals("mulund")) {
            if (Destination.equals("Thane") || Destination.equals("Thane")) {
                price2 = 5;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Thane") || Destination.equals("thane")) {
                price2 = 10;
                call();
                button(current_location,Destination);

            } else if (Destination.equals("Airoli") || Destination.equals("airoli")) {
                price2 = 15;
                call();
                button(current_location,Destination);

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                builder.setMessage("We not are located in " + Destination +"\nOR\n"+"Your Spelling is incorrect" + "\nPlease Select from following location 'Thane, Mulund, Airoli, Kalwa' ")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }

        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
            builder.setMessage("We are not located in " + current_location + "\nOR\n" + "Your Spelling is incorrect" + "\nPlease Select from following location 'Thane, Mulund, Airoli, Kalwa' ")
                    .setNegativeButton("Retry", null)
                    .create()
                    .show();
        }
    }
    private int calculateprice() {
        int price = quantity * price2;
        return price;
    }


    private String createOrdersummary(String current_location,String Destination, String username) {
        String PriceMessage = "Price: ₹ ";
        PriceMessage = PriceMessage + (quantity * price2);
        PriceMessage = PriceMessage + "\nCurrent Location: " + current_location;
        PriceMessage = PriceMessage + "\nDestination: " + Destination;
        PriceMessage = PriceMessage + "\nQuantity: " + quantity;
        PriceMessage = PriceMessage + "\nUsername: " + username;
        return PriceMessage;
    }

    /**
     * This method is called when the PLus button is clicked.
     */

    public void increment(View view) {
        if (quantity == 8) {
            display(quantity);
            display2("Maximum 8 Ticket on One Booking");
        } else {
            quantity += 1;
            display(quantity);
            display2(" ");
        }


    }

    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            display(quantity);
            display2(" ");
        } else {
            display(quantity);
            display2("Minimum 1 Ticket you have to Book");
        }
    }


    /**
     * Order summary method created
     */


    private void button(String current_location,String Destination){
        Intent intent2 = getIntent();
        final int balance = intent2.getIntExtra("balance", -1);
        final String username = intent2.getStringExtra("username");


        int price = calculateprice();
        final String priceMessage1 = createOrdersummary(current_location, Destination, username);
        if (balance < (quantity * price2)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
            builder.setMessage("Insufficient Balance. \nPlease Recharge your account from nearest Bus Service Center")
                    .setNegativeButton("Close Alert", null)
                    .create()
                    .show();
        } else {
            if (balance == balance4) {
                displayPrice(balance);
            } else {
                displayPrice(balance4);
            }

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        int ticketid = jsonResponse.getInt("ticketid");
                        if (success) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                            builder.setMessage("Your Ticket ID " + ticketid + "\n" + priceMessage1 + "\n Remaining balance: ₹ " + balance4)
                                    .setNegativeButton("Book again ", null)
                                    .create()
                                    .show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                            builder.setMessage("Register Failed")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            TbookRequest registerRequest = new TbookRequest(current_location, Destination, username, price, quantity, responseListener);
            RequestQueue queue = Volley.newRequestQueue(TBooking.this);
            queue.add(registerRequest);

        }
    }

    private void call() { if(balance4>=(quantity * price2)){
        Intent intent2 = getIntent();
        final String username = intent2.getStringExtra("username");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        //donothing
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TBooking.this);
                        builder.setMessage("Register Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        BalanceUpdate registerRequest = new BalanceUpdate(username, (balance4 - (quantity * price2)), responseListener);
        RequestQueue queue = Volley.newRequestQueue(TBooking.this);
        queue.add(registerRequest);
    }else{//Do Nothing
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int Quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + Quantity);
    }

    private void display1(String Quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText(Quantity);
    }

    private void display2(String Quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.max);
        quantityTextView.setText(Quantity);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void display3(String Quantity) {
        TextView Username = (TextView)findViewById(R.id.textView2121);
        Username.setText("Username: " + Quantity);
    }

    private void display4(int balance) {
        TextView tvbalance = (TextView)findViewById(R.id.textView212);
        tvbalance.setText("Balance: ₹ " + balance + "");
    }

    private void displayPrice(int number) {
         balance4 = number - (quantity*price2);
        TextView priceTextView = (TextView) findViewById(R.id.textView212);
        priceTextView.setText("Balance: ₹ " + balance4);
    }
    private void buttonprice(String current_l,String Destination,int number) {
        TextView priceTextView = (TextView) findViewById(R.id.pricetext);
        priceTextView.setText("Fare for per person \nFrom "+current_l+" to "+Destination+" is ₹ " + number + "\nYour Total Fare is : ₹"+ (quantity*price2));
    }
}
