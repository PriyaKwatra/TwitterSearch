package com.example.acer.twittersearch;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText search;
    OkHttpClient client;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    Context c;
    OuterClass outer;

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putParcelable("key",outer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=(EditText)findViewById(R.id.edit1);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.button1);
         client =new OkHttpClient();
        c=this;
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(manager);
        if(savedInstanceState!=null)
        {

            outer=savedInstanceState.getParcelable("key");
            recyclerView.setAdapter(new RecyclerClass(outer,c));

        }





        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   String s=search.getText().toString();

                Request request=new Request.Builder().url("https://loklak.org/api/search.json?q="+s).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                      String result=response.body().string();
                        Gson gson=new Gson();

                       outer=gson.fromJson(result,OuterClass.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setAdapter(new RecyclerClass(outer,c));
                            }
                        });




                    }
                });



            }
        });




    }



}
