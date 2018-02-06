package com.example.ebus.abkapp;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Updatecheck extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://vikasrajyadav.com/vry/updatecheck.php";
    private Map<String, String> params;

    public Updatecheck(int ticketid, Boolean b12, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("ticketid", ticketid + "");
        params.put("boolean", b12 + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
