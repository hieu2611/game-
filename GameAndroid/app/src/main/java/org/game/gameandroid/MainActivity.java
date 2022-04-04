package org.game.gameandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.game.gameandroid.adapter.OMauAdapter;
import org.game.gameandroid.dilog.KetThucGameDilog;
import org.game.gameandroid.object.DinhNghia;
import org.game.gameandroid.object.InFotNguoiChoi;
import org.game.gameandroid.object.OMau;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int diemSo;
    DinhNghia dinhNghia = new DinhNghia();

    ArrayList<OMau> arrOMau = new ArrayList<>();
    GridView gdvListOmau;
    OMauAdapter adapter;

    TextView txvLevel;
    TextView Time;
    TextView diem;
    TextView txvCoin;
    CountDownTimer count;
    InFotNguoiChoi nguoiChoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init(){
        nguoiChoi = new InFotNguoiChoi(this);
        nguoiChoi.getData();
        taoMau();
        adapter = new OMauAdapter(this, 0, arrOMau);
    }

    private void anhXa(){
        gdvListOmau = findViewById(R.id.gdvListOmau);
        txvLevel = findViewById(R.id.txvLevel);
        Time = findViewById(R.id.Time);
        diem = findViewById(R.id.diem);
        txvCoin = findViewById(R.id.txvCoin);

    }

    private void setUp(){
        txvCoin.setText(""+nguoiChoi.tienNguoiChoi);
        gdvListOmau.setNumColumns(dinhNghia.soCot);
        gdvListOmau.setAdapter(adapter);
        txvLevel.setText(""+dinhNghia.level);
        updateTime();
    }
    private void setClick(){
        gdvListOmau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkMau(arrOMau.get(i));
            }
        });
    }

    private void checkMau(OMau o){
        if (o.maMau.equals(dinhNghia.mauIt)){

            dinhNghia.level++;
            try {
                diemSo = dinhNghia.getDiem();
                if(dinhNghia.level < 3){
                    diemSo += 20;
                }else if (dinhNghia.level < 10){
                    diemSo += 50;
                }else if (dinhNghia.level < 25){
                    diemSo += 70;
                }else if (dinhNghia.level < 49){
                    diemSo += 110;
                }else if (dinhNghia.level < 59){
                    diemSo += 150;
                }else if (dinhNghia.level < 69){
                    diemSo += 170;
                }else if (dinhNghia.level < 99){
                    diemSo += 190;
                }else {
                    diemSo += 200;
                }

                dinhNghia.setDiem(diemSo);

            }catch (Exception e){
                Log.e("diemSo", e.toString());
            }
            taoMau();
            update();
            updateDiem();
            dinhNghia.timeChay += 1000;
            count.cancel();
            updateTime();
        }else{
            if(dinhNghia.getDiem() >= 50){
                diemSo -= 50;
                dinhNghia.setDiem(diemSo);
                updateDiem();
                Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
            }else{
                thua();
            }
        }
    }
    private void taoMau(){
        dinhNghia.setLevel();
        dinhNghia.layMauNgauNhien();

        arrOMau.clear();
        while (arrOMau.size() < dinhNghia.soO){
            arrOMau.add(new OMau(dinhNghia.mauNhieu));
        }
        Random random = new Random();

        arrOMau.get(random.nextInt(arrOMau.size())).maMau= dinhNghia.mauIt;
    }

    private void update(){
        adapter.update(arrOMau);
        gdvListOmau.setNumColumns(dinhNghia.soCot);
        txvLevel.setText(""+dinhNghia.level);

    }

    private void updateTime()
    {
        count = new CountDownTimer(dinhNghia.timeChay, 1){
            @Override
            public void onTick(long l) {
                dinhNghia.timeChay = (int) l;
                if (dinhNghia.timeChay>=0){
                    int soGiay = dinhNghia.timeChay/1000;
                    int soMiliGiay = dinhNghia.timeChay%1000/10;
                    String times = soGiay + " : "+ soMiliGiay;
                    Time.setText(times);

                }else{

                }

            }

            @Override
            public void onFinish() {
                Time.setText("00 : 00");
                hetGio();
            }// đếm millisecond

        }.start();
    }
    private void hetGio(){
        gdvListOmau.setOnItemClickListener(null);
        Toast.makeText(this, "Hết giờ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, KetThucActivity.class);
        intent.putExtra("level", dinhNghia.level);
        intent.putExtra("diem", dinhNghia.getDiem());
        startActivity(intent);
        finish();
        //new KetThucGameDilog(this, dinhNghia.level, dinhNghia.getDiem()).show();
        saveCoin();
    }

    private void thua(){
        count.cancel();
        gdvListOmau.setOnItemClickListener(null);
        Toast.makeText(this, "Thua", Toast.LENGTH_SHORT).show();
        saveCoin();
    }
    public void updateDiem(){
        diem.setText(dinhNghia.getDiem()+"");
    }

    public void saveCoin(){
        int luuTru = dinhNghia.getDiem();
        float tong = luuTru * 0.001f;
        nguoiChoi.tienNguoiChoi += tong;

        txvCoin.setText(""+nguoiChoi.tienNguoiChoi);
        nguoiChoi.setData();
    }
}