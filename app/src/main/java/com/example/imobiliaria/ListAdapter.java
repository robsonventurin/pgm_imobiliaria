package com.example.imobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {

    Context context;
    private final ArrayList<Imovel> imoveis;

    public ListAdapter(Context context, ArrayList<Imovel> imoveis){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.imoveis = imoveis;
    }

    @Override
    public int getCount() {
        return imoveis.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.aValuetxt);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.aTypetxt);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtName.setText(imoveis.get(position).getName().toString());
        viewHolder.txtType.setText(imoveis.get(position).getType().toString());
        viewHolder.txtVersion.setText("R$ " + imoveis.get(position).getValue().toString());
        viewHolder.icon.setImageResource(imoveis.get(position).getImage());

        return convertView;
    }

    private static class ViewHolder {

        TextView txtType;
        TextView txtName;
        TextView txtVersion;
        ImageView icon;

    }

}