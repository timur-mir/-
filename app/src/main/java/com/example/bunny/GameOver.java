package com.example.bunny;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    TextView tvPoints;
    TextView tvHighest;
    SharedPreferences sharedPreferences;
    ImageView ivNewHighest;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        tvPoints=findViewById(R.id.tvPoints);
        tvHighest=findViewById(R.id.tvHighest);
       ivNewHighest=findViewById(R.id.ivNewHighest);
       int points = getIntent().getExtras().getInt("points");
        tvPoints=findViewById(R.id.tvPoints);
        tvPoints.setText(""+ points);
        sharedPreferences = getSharedPreferences("my_pref",0);
        int highest=sharedPreferences.getInt("highest",0);
        if(points > highest){
            ivNewHighest.setVisibility(View.VISIBLE);
            highest=points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest",highest);
            editor.apply();
            tvHighest.setText(""+highest);
                    }
        else
        {
            tvHighest.setText(""+highest);
        }

    }
    public void restart(View view) {
        Intent intent = new Intent(GameOver.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void exit(View view) {
        finish();
    }
}
