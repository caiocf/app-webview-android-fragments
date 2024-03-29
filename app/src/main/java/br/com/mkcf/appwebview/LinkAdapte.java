package br.com.mkcf.appwebview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.mkcf.appwebview.modelo.LinkData;

import java.util.List;

class LinkAdapter extends ArrayAdapter<LinkData> {

    private Context ctx;
    private List<LinkData> linkDataList;

    public LinkAdapter(List<LinkData> linkDataList, Context ctx) {
        super(ctx, R.layout.row_layout,linkDataList);
        this.ctx = ctx;
        this.linkDataList = linkDataList;
    }

    @Override
    public int getCount() {
        return linkDataList.size();
    }

    @Override
    public LinkData getItem(int position) {
        return linkDataList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return linkDataList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("SwA", "Adapter getView");
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.row_layout, null);
        }

        TextView tName = (TextView) v.findViewById(R.id.name);
        TextView lName = (TextView) v.findViewById(R.id.link);

        LinkData ld = linkDataList.get(position);
        tName.setText(ld.getName());
        lName.setText(ld.getLink());

        return v;

    }



}