package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterMemoPad extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<MemoPad> arrMemoPad;

    public AdapterMemoPad(Context myContext, int myLayout, List<MemoPad> arrMemoPad) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrMemoPad = arrMemoPad;
    }

    @Override
    public int getCount() {
        return arrMemoPad.size();
    }

    @Override
    public Object getItem(int i) {
        return arrMemoPad.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(myLayout, viewGroup,false);

        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setText(arrMemoPad.get(i).title);

        TextView txtDate = (TextView) view.findViewById(R.id.txtDate);
        SimpleDateFormat date = new SimpleDateFormat("HH:mm");
        String time = date.format(new Date());
        txtDate.setText(time);

        ImageView imgView = (ImageView) view.findViewById(R.id.imgViewNew);
        imgView.setImageResource(R.drawable.ic_event_note_black_48dp);

        return view;
    }
}
