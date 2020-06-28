package com.example.organdonationapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RecordAdapter extends FirebaseRecyclerAdapter<User, RecordAdapter.RecordViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecordAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecordViewHolder holder, int position, @NonNull User model) {
        holder.tvname.setText(model.getName());
        holder.tvEmail.setText(model.getEmail());
        holder.tvaddress.setText(model.getAddress());
        holder.tvcontact.setText(model.getContact());
        holder.tvtype.setText(model.getUsertype());
        holder.tvblood.setText(model.getBloodgroup());
        holder.tvorgan.setText(model.getOrgan());
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listrecorditem,parent,false);
        return new RecordViewHolder(view);
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder
    {
            TextView tvname,tvEmail,tvaddress,tvcontact,tvtype,tvblood,tvorgan;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvaddress = itemView.findViewById(R.id.tvaddress);
            tvcontact = itemView.findViewById(R.id.tvcontact);
            tvtype = itemView.findViewById(R.id.tvtype);
            tvblood = itemView.findViewById(R.id.tvblood);
            tvorgan = itemView.findViewById(R.id.tvorgan);




        }
    }
}
