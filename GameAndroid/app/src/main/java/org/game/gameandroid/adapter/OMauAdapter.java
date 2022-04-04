package org.game.gameandroid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.game.gameandroid.R;
import org.game.gameandroid.object.ImgCustom;
import org.game.gameandroid.object.OMau;

import java.util.ArrayList;
import java.util.List;

public class OMauAdapter extends ArrayAdapter<OMau> {
    private Context ct;
    private ArrayList<OMau> arrOMau;

    public OMauAdapter(@NonNull Context context, int resource, @NonNull List<OMau> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arrOMau = new ArrayList<>(objects) ;
    }

    public void update (ArrayList<OMau> arr){
        this.arrOMau.clear();

        this.arrOMau.addAll(arr);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrOMau.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.item_o_mau, null);
        }
        if (arrOMau.size() > 0){
            OMau o = arrOMau.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.imgOMau);
            imgCustom.setColorFilter(Color.parseColor(o.maMau));
        }
        return convertView;
    }
}
