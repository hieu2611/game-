package org.game.gameandroid.object;

import java.util.Random;

public class DinhNghia {

    public int soCot = 7;
    public int soO = 7;

    public String mauNhieu = "#FF0000";
    public String mauIt = "#FA5858";

    private String arrMauNhieu[] = new String[]{
            "#FF0000",
            "#DF7401",
            "#D7DF01",
            "#A5DF00",
            "#40FF00",
            "#01DFD7",
            "#0000FF",
            "#8904B1",
            "#DF01D7",
            "#DF0174",
            "#FF0040"
    };

    public int level = 1;
    public int timeTong = 20;
    public int timeChay = timeTong*1000;
    private int diem = 0;

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    private String arrMauIt[] = new String[]{
            "#FA5858",
            "#FE9A2E",
            "#F3F781",
            "#D0FA58",
            "#9FF781",
            "#58FAF4",
            "#5858FA",
            "#A901DB",
            "#FE2EF7",
            "#FE2E9A",
            "#FA5882"
    };

    public void setLevel(){

        if(level < 3){
            soCot = 2;
        }else if (level < 10){
            soCot = 5;
        }else if (level < 25){
            soCot = 8;
        }else if (level < 49){
            soCot = 10;
        }else if (level < 59){
            soCot = 12;
        }else if (level < 69){
            soCot = 16;
        }else if (level < 99){
            soCot = 20;
        }else {
            soCot = 25;
        }

        soO = soCot * soCot;
    }
    public void layMauNgauNhien(){
        Random r = new Random();

        int vt = r.nextInt(arrMauNhieu.length);
        mauNhieu = arrMauNhieu[vt];
        mauIt = arrMauIt[vt];

    }
}
