package com.example.managements;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyView_Holder extends RecyclerView.ViewHolder {

    TextView fname,lname,email,mobile,course,sid;
    Button delete,update,detail;
    public MyView_Holder(@NonNull View itemView) {
        super(itemView);
        sid=itemView.findViewById(R.id.students_ID_id);
        fname=itemView.findViewById(R.id.fname_c_id);
        lname=itemView.findViewById(R.id.lname_c_id);
        email=itemView.findViewById(R.id.email_c_id);
        mobile=itemView.findViewById(R.id.mobile_c_id);
        course=itemView.findViewById(R.id.course_c_id);
        delete=itemView.findViewById(R.id.delete_btn_c_id);
        update=itemView.findViewById(R.id.update_btn_C_id);
        detail=itemView.findViewById(R.id.delete_btn_c_id);

    }
}
