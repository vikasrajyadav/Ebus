package com.example.ebus.abkapp;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SearchRequestCL extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://vry.vipiny.com/SearchTicketyIDCL.php";
    private Map<String, String> params;

    public SearchRequestCL(int ticketid, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("ticketid", ticketid + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
