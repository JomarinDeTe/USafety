package com.example.usafety;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Dashboard extends Fragment {
    private TextView tvTotalConfirmed,tvTotalTodayActive, tvTotalDeath, tvTotalRecovered;
    private ProgressBar progressBar;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        tvTotalTodayActive= root.findViewById(R.id.lblTotalNumberCases);
        tvTotalConfirmed = root.findViewById(R.id.lblTotalNumberConfirmed);
        tvTotalDeath = root.findViewById(R.id.lblTotalNumberDeath);
        tvTotalRecovered = root.findViewById(R.id.lblTotalNumberRecovered);
        progressBar = root.findViewById(R.id.progress_circular_home);;
        getData();


        return root;
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://disease.sh/v3/covid-19/countries/philippines";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            progressBar.setVisibility(View.GONE);

            try {
                JSONObject jsonObject = new JSONObject(response.toString());
                tvTotalTodayActive.setText(jsonObject.getString("active"));
                tvTotalConfirmed.setText(jsonObject.getString("todayCases"));
                tvTotalDeath.setText(jsonObject.getString("todayDeaths"));
                tvTotalConfirmed.setText(jsonObject.getString("cases"));
                tvTotalDeath.setText(jsonObject.getString("deaths"));
                tvTotalRecovered.setText(jsonObject.getString("recovered"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            progressBar.setVisibility(View.GONE);
            Log.d("Error Response", error.toString());
        });
        queue.add(stringRequest);
    }


}