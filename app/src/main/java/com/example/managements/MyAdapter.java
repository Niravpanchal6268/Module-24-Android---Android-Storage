package com.example.managements;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyView_Holder> {
    ArrayList<model> slist;
    Context context;

    public MyAdapter(ArrayList<model> slist, Context context) {
        this.slist = slist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.students_card, parent, false);
        return new MyView_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView_Holder holder, @SuppressLint("RecyclerView") int position) {
        final model temp = slist.get(position);
        holder.fname.setText(slist.get(position).getFname());
        holder.lname.setText(slist.get(position).getLname());
        holder.email.setText(slist.get(position).getEmail());
        holder.mobile.setText(slist.get(position).getMobile());
        holder.course.setText(slist.get(position).getCourse());
        holder.sid.setText(String.valueOf(slist.get(position).getSid()));

        StudentsDB_Class dbClass = new StudentsDB_Class(context);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean d = dbClass.deletestudents(temp.sid);
                if (d == true) {
                    Toast.makeText(context, "delete students successfully", Toast.LENGTH_SHORT).show();
                    slist.remove(position);
                    notifyDataSetChanged();


                } else {
                    Toast.makeText(context, "not", Toast.LENGTH_SHORT).show();

                }


            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "update", Toast.LENGTH_SHORT).show();
                Dialog dialog = new Dialog(context);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setTitle("Update students");
                dialog.setContentView(R.layout.update_layout);
                TextInputLayout fnameu=dialog.findViewById(R.id.firstname_u_id);
                TextInputLayout lname=dialog.findViewById(R.id.lastname_U_id);
                TextInputLayout email=dialog.findViewById(R.id.eamil_u_id);
                TextInputLayout mobile=dialog.findViewById(R.id.mobile_u_id);
                MaterialButton update_btn=dialog.findViewById(R.id.update_btn_layout_id);
                update_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Fnameu=fnameu.getEditText().getText().toString();
                        String Lnameu=lname.getEditText().getText().toString();
                        String  Emailu=email.getEditText().getText().toString();
                        String Mobile=mobile.getEditText().getText().toString();
                        if (Fnameu.isEmpty()||Lnameu.isEmpty()||Emailu.isEmpty()||Mobile.isEmpty())
                        {
                            Toast.makeText(context, "Fill all the fields", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(context, "name11", Toast.LENGTH_SHORT).show();
                            boolean update= dbClass.update(temp.sid,Fnameu,Lnameu,Emailu,Mobile);
                            if (update==true)
                            {
                                Toast.makeText(context, "update", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                                
                            }
                            else {
                                Toast.makeText(context, "not", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                });

                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return slist.size();
    }
}
