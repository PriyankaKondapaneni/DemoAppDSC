package com.codewithsiri.demoappdsc.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.codewithsiri.demoappdsc.MyAdapter;
import com.codewithsiri.demoappdsc.R;
import com.codewithsiri.demoappdsc.items;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<items> itemsList;
    private static String JSON_URL = "https://wayhike.com/dsc/demo_app_api.php";
    MyAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        itemsList = new ArrayList<>();
        recyclerView = root.findViewById(R.id.recyclerview);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        extractItems();
        return root;
    }
    private void extractItems() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest request = new JsonObjectRequest(JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                    try {for (int i = 0; i < response.length(); i++) {

                        JSONArray jsonArray = response.getJSONArray("event_titles");

                        String event = jsonArray.getString(i);
                        items items = new items();
                        items.setEvents(event);
                        itemsList.add(items);
                    }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                adapter.setData(itemsList);
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
                    }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });
        queue.add(request);
    }


 }

