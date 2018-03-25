package com.example.ayupriyambodo.modul5a;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AYUPRIYAMBODO on 25/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context cntx;
    private List<AddData> list;
    int color;

    public adapter(Context ctx, List<AddData> list, int color){
        this.cntx = cntx;
        this.list = list;
        this.color = color;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cntx).inflate(R.layout.cardview_list, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    @Override
    public void onBindViewHolder(adapter.holder holder, int position) {
        AddData data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Deskripsi.setText(data.getDesk());
        holder.Priority.setText(data.getPrior());
        holder.cardView.setCardBackgroundColor(cntx.getResources().getColor(this.color));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public AddData getData(int position){
        return list.get(position);
    }
    public void deleteData(int i){
        list.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        public TextView ToDo, Deskripsi, Priority;
        public CardView cardView;
        public holder(View itemView){
            super(itemView);

            ToDo = itemView.findViewById(R.id.editTodo);
            Deskripsi = itemView.findViewById(R.id.editDeskripsi);
            Priority = itemView.findViewById(R.id.editPriority);
            cardView = itemView.findViewById(R.id.cardlist);
        }
    }

}
