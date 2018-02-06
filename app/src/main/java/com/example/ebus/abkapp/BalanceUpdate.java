package com.example.ebus.abkapp;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BalanceUpdate extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://vikasrajyadav.com/vry/balance.php";
    private Map<String, String> params;

    public BalanceUpdate(String username, int balance, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("balance", balance + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
