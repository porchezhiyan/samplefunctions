package com.example.rmdec.sample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.id.list;

public class Main2Activity extends AppCompatActivity {


    String jsonString;
    JSONObject jsonObject;
    JSONArray jsonArray;
    SubscribersAdaptor subscribersAdaptor;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //after removing text view

        listView =(ListView)findViewById(R.id.lview);
        listView.setAdapter(subscribersAdaptor);

        subscribersAdaptor = new SubscribersAdaptor(this,R.layout.row_layout);














        //start




        int sockettimeout = 30000000;
        RetryPolicy poilicy = new DefaultRetryPolicy(sockettimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);


//        final TextView mTextView = (TextView)findViewById(R.id.result);
//        mTextView.setMovementMethod(new ScrollingMovementMethod());
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "http://zillionthoughts.com/?json=1";
        String url = "http://10.0.7.29:8080/subscriber/";
        //VolleySingleton=VolleySingleton.getInstance();
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,(String)null, new Response.Listener<JSONObject>() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                mTextView.setText("the response is:"+response.toString());
                jsonString = response.toString();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText(error.toString());
            }
        });

        request.setRetryPolicy(poilicy);


///Users/rmdec/Downloads/Sample2/app


        /*
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mTextView.setText("the response is:"+response.substring(0,5500));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("that didnt work");
            }
        });*/

        queue.add(request);


        try {
            jsonObject = new JSONObject(jsonString);

            jsonArray = jsonObject.getJSONArray("subscribers");

            int count=0;

            String name;
            int age,id;

            while(count<jsonArray.length()){
                JSONObject jo =jsonArray.getJSONObject(count);
                name = jo.getString("name");
                id = jo.getInt("id");
                age = jo.getInt("age");


                Subcribers subcribers = new Subcribers(name,id,age);




                subscribersAdaptor.add(subcribers);

                count++;




            }





        } catch (JSONException e) {
            e.printStackTrace();
        }


        //end
    }
}
