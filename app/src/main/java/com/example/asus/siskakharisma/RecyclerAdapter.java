package com.example.asus.siskakharisma;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ASUS on 2/23/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Mahasiswa> mahasiswa;
   // private LayoutInflater inflater;
    private Context context;

    public RecyclerAdapter(Context context, List<Mahasiswa> itemmahasiswa){
        this.context = context;
     //   inflater = LayoutInflater.from(context);
        this.mahasiswa = itemmahasiswa;
    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType ){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Mahasiswa current = mahasiswa.get(position);
        holder.setData(current,position);
        holder.setListeners();
    }
    @Override
    public int getItemCount(){
        return mahasiswa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, email, status;
        ImageView thumnail;
        int position;
        Mahasiswa current;

        View itemView;

        public MyViewHolder(View itemView){
            super(itemView);

            this.itemView = itemView;

            nim = (TextView) itemView.findViewById(R.id.tvNim);
            nama = (TextView) itemView.findViewById(R.id.tvNama);
            email = (TextView) itemView.findViewById(R.id.tvEmail);
            status = (TextView) itemView.findViewById(R.id.tvStatus);
            thumnail = (ImageView) itemView.findViewById(R.id.img_row);
        }

        public void setData(Mahasiswa current, int position){
            String nim = current.getNim();
            String angkatan = nim.substring(3,5);
            String prodi = nim.substring(0,3);
            String imageUrl = "https://siska4.kharisma.ac.id/assets/img/foto/mhs/"+angkatan+"/"+prodi+"/"+nim+".jpg";
            Glide.with(context).load(imageUrl).into(thumnail);

            this.nim.setText(current.getNim());
            this.nama.setText(current.getNama());
            this.email.setText(current.getEmail());
            this.status.setText(current.getStatus());

            this.position = position;
            this.current = current;
        }
        public void setListeners(){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentCommunicator fragmentCommunicator = (FragmentCommunicator)context;
                    fragmentCommunicator.displayDetail(current);
                }
            });
        }
    }
}
