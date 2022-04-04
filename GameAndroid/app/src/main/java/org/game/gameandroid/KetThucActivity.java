package org.game.gameandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class KetThucActivity extends AppCompatActivity {
    TextView txvLevel;
    TextView Diem;

    int level = 0, diem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_thuc);
        init();
        anhXa();
        setCkick();
        setUp();
    }

    private void init(){
        level = getIntent().getIntExtra("level", 0);
        diem = getIntent().getIntExtra("diem", 0);
    }
    private void anhXa(){

       txvLevel = findViewById(R.id.txvLevel);

       Diem = findViewById(R.id.diem);

    }
    private void setUp(){
        txvLevel.setText(""+level);
        Diem.setText(""+diem);
    }
    private void setCkick(){}

    public void choiLai(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void thoatGame(View view){
        finish();
    }
}