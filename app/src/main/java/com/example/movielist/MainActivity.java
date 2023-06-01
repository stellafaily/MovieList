package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] titles = { "한산: 용의 출현", "탑건: 메버릭", "비상선언", "헤어질 결심", "덤블도어의 비밀",
            "헌트1", "헌트2", "헌트3", "헌트4", "헌트5" };
    int[] images = {R.drawable.movie1,R.drawable.movie2, R.drawable.movie3, R.drawable.movie4, R.drawable.movie5,
            R.drawable.movie6, R.drawable.movie6, R.drawable.movie6, R.drawable.movie6, R.drawable.movie6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(titles, images);
        customAdapter.setOnItemClickListner(new CustomAdapter.OnItemclickListner() {
            @Override
            public void onItemClickListner(View v, int pos) {
                Toast.makeText(getApplicationContext(),"위치:["+ pos +"], 영화:["+ titles[pos] +"] 선택",
                        Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(customAdapter);

    }
}