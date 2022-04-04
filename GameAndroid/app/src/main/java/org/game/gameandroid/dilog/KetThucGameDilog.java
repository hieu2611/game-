package org.game.gameandroid.dilog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.game.gameandroid.R;

public class KetThucGameDilog extends Dialog{
    public KetThucGameDilog(@NonNull Context context, int level, int diem) {
        super(context);
        setContentView(R.layout.dilog_het_game);

        TextView txvLevel = findViewById(R.id.txvLevel);
        txvLevel.setText(""+level);
        TextView Diem = findViewById(R.id.diem);
        Diem.setText(""+diem);

    }
}
