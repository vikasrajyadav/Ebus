package com.example.ebus.abkapp;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TbookRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://vikasrajyadav.com/vry/ticketbooked.php";
    private Map<String, String> params;
    Boolean value = false;

    public TbookRequest(String currentl, String Destination, String username, int price, int quantity, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("current_l", currentl);
        params.put("destination",Destination);
        params.put("quantity", quantity + "");
        params.put("ticketprice", price + "");
        params.put("bool", value + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
