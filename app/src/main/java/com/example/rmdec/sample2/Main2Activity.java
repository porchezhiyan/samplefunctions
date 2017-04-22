package com.example.rmdec.sample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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


    String jsonString =" ";
    JSONObject jsonObject;
    JSONArray jsonArray;
    SubscribersAdaptor subscribersAdaptor;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        jsonString = getIntent().getExtras().getString("json_data");
        //after removing text view
        Toast.makeText(getApplicationContext(),jsonString+"atmain2",Toast.LENGTH_LONG).show();

        listView =(ListView)findViewById(R.id.lview);

        subscribersAdaptor = new SubscribersAdaptor(this,R.layout.row_layout);

        listView.setAdapter(subscribersAdaptor);






        try {

            //jsonString = "{subscribers: {1: {age: 38, id: 1, name: Rocky}, 2: {age: 50, id: 2, name: Steve}, 3: {age: 38, id: 3, name: Melinda}}}";
            jsonObject = new JSONObject(jsonString);

            jsonObject= jsonObject.getJSONObject("subscribers");

            //jsonObject = jsonObject.getJSONObject("1");





            int count=1;

            String name;
            int age,id;


            //Toast.makeText(getApplicationContext(),jsonObject.getString("age"),Toast.LENGTH_LONG).show();

            JSONObject jsonObject1 = null;

            while(count<=jsonObject.length()){

                Toast.makeText(getApplicationContext(),Integer.toString(count),Toast.LENGTH_LONG).show();

//                JSONObject jo =jsonObject.getJSONObject(Integer.toString(count));
                jsonObject1 =jsonObject.getJSONObject(Integer.toString(count));

                Toast.makeText(getApplicationContext(),jsonObject1.getString("name"),Toast.LENGTH_LONG).show();
                name = jsonObject1.getString("name");
                id = jsonObject1.getInt("id");
                age = jsonObject1.getInt("age");


                Subcribers subcribers = new Subcribers(getApplicationContext(),name,id,age);




                subscribersAdaptor.add(subcribers);

                count++;




            }





        } catch (JSONException e) {
            e.printStackTrace();
        }


        //end
    }
}
