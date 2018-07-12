package com.example.helderrocha.testerec.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.helderrocha.testerec.R;

public class MainFragment extends Fragment {

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url = "http://www.mocky.io/v2/5b4760452f00004800481537";
    private Object REQUESTTAG = "string request first";

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false);
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        sendRequestAndPrintResponse();

        return view;
    }

    private void sendRequestAndPrintResponse() {
        requestQueue = Volley.newRequestQueue(getContext());
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("SUCESSO:", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ERROR:", error.toString());
            }
        });

        stringRequest.setTag(REQUESTTAG);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onStop() {
        super.onStop();
        if (requestQueue != null){
            requestQueue.cancelAll(REQUESTTAG);
        }
    }
}
