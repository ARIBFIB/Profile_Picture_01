package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    String url = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = findViewById(R.id.tv);
        tv.setText("");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        myapi api = retrofit.create(myapi.class);

        Call<List<Model>> call = api.getModel();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data = response.body();
                for (int i = 0; i < data.size(); i++) {
                    tv.append("Id :" + data.get(i).getId() + "\nname :" + data.get(i).getName() + "\nusername :" + data.get(i).getUsername() + "\nemail :" + data.get(i).getEmail() + "\naddress :" + data.get(i).getAddress() +
                            "\nstreet :" + data.get(i).getStreet() + "\nsuite :" + data.get(i).getSuit() + "\nzipcode :" + data.get(i).getZipcode() + "\ngeo :" + data.get(i).getGeo() + "\nlat :"
                            + data.get(i).getLat() + "\nlng :" + data.get(i).getLng() + "\nphone :" + data.get(i).getPhone() + "\nwebsite :" + data.get(i).getWebsite() + "\ncompany :" + data.get(i).getCompany() + "\nname :" + data.get(i).getName() + "\ncatchPhrase :" + data.get(i).getCatchPhrase() + "\nbs :" + data.get(i).getBs() +
                            "\nbody" + data.get(i).getBody() + "\n\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No connection, Connect to the internet", Toast.LENGTH_SHORT);
            }

        });
    }
}



