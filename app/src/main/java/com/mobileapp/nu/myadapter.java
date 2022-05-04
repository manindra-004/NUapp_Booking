package com.mobileapp.nu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.demail.setText(dataholder.get(position).getEmail());
        holder.ddate.setText(dataholder.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dcontact,demail,ddate;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.displayname);
            dcontact=(TextView)itemView.findViewById(R.id.displaycontact);
            demail=(TextView)itemView.findViewById(R.id.displayemail);
            ddate=(TextView)itemView.findViewById(R.id.displaydate);
        }
    }

}
