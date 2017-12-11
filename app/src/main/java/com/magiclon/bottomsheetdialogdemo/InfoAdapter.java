package com.magiclon.bottomsheetdialogdemo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 *
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {
    private List<ApplicationInfo> mList;
    private Context mContext;

    public InfoAdapter(List<ApplicationInfo> list, Context context) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.appcion.setImageDrawable(mList.get(position).loadIcon(mContext.getPackageManager()));
        holder.packagename.setText(mList.get(position).packageName);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView appcion;
        public TextView packagename;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.appcion =  rootView.findViewById(R.id.appcion);
            this.packagename = rootView.findViewById(R.id.packagename);

        }

    }
}
