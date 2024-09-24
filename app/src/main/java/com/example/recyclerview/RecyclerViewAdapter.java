package com.example.recyclerview;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> idList;
    private ArrayList<String> nameList;

    public RecyclerViewAdapter(ArrayList<String> idList, ArrayList<String> nameList) {
        this.idList = idList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = new LinearLayout(parent.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        TextView textViewId = new TextView(parent.getContext());
        textViewId.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        textViewId.setTextSize(16);

        TextView textViewName = new TextView(parent.getContext());
        textViewName.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        textViewName.setTextSize(14);

        layout.addView(textViewId);
        layout.addView(textViewName);

        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewId.setText(idList.get(position));
        holder.textViewName.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return idList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewName;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            textViewId = (TextView) itemView.getChildAt(0);
            textViewName = (TextView) itemView.getChildAt(1);
        }
    }
}
