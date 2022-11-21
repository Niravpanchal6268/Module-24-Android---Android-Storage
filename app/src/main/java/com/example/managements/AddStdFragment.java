package com.example.managements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddStdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddStdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddStdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddStdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddStdFragment newInstance(String param1, String param2) {
        AddStdFragment fragment = new AddStdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    Spinner course_spi, city_spi;

    TextInputLayout fname,lname,email,address,pincode,tootalfee,mobile;
    MaterialButton sumbit;

    String[] courses = {"Select course", "C", "C++", "Data structures",
            "Interview prep", "Algorithms", "Android", "Pythone",
            "DSA with java", "WD", "FD", "Testing"};
    String[] city = {"Select City", "Ahmedabad", "Surat", "Rajkot", "Gandhinagar", "Baroda"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view =inflater.inflate(R.layout.fragment_add_std,container,false);
        course_spi = view.findViewById(R.id.course_spin_id);
        course_spi.setPrompt("Select course");
        ArrayAdapter carra = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, courses);
        carra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spi.setAdapter(carra);
        //city spinner
        city_spi = view.findViewById(R.id.city_spi_id);
        city_spi.setPrompt("Select city");
        ArrayAdapter cityarra = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, city);
        cityarra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city_spi.setAdapter(cityarra);
        sumbit=view.findViewById(R.id.sumbit_btn_id);
        fname=view.findViewById(R.id.firstname_id);
        lname=view.findViewById(R.id.lastname_id);
        email=view.findViewById(R.id.email_id);
        address=view.findViewById(R.id.address_id);
        pincode=view.findViewById(R.id.pincode_id);
        tootalfee=view.findViewById(R.id.totalfee_id);
        mobile=view.findViewById(R.id.mobile_id);
        sumbit=view.findViewById(R.id.sumbit_btn_id);
        StudentsDB_Class dbClass = new StudentsDB_Class(getActivity());
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fname,Lname,Email,Address,Pincode,TootalFee,Mobile,Course,City;

                Fname=fname.getEditText().getText().toString();
                Lname=lname.getEditText().getText().toString();
                Email=email.getEditText().getText().toString();
                Address=address.getEditText().getText().toString();
                Pincode=pincode.getEditText().getText().toString();
                TootalFee=tootalfee.getEditText().getText().toString();
                Mobile=mobile.getEditText().getText().toString();
                Course=course_spi.getSelectedItem().toString();
                City=city_spi.getSelectedItem().toString();
                if (Fname.isEmpty()||Lname.isEmpty()||Email.isEmpty()||Address.isEmpty()||Pincode.isEmpty()||TootalFee.isEmpty()||Mobile.isEmpty()||Course.isEmpty()||City.isEmpty())
                {
                    Toast.makeText(getActivity(), "FILL ALL THE FILED", Toast.LENGTH_SHORT).show();

                }
                else {

                    boolean i=dbClass.insertdetail(Fname,Lname,Email,Course,Address,Pincode,City,TootalFee,Mobile);
                    if (i == true) {
                        Toast.makeText(getActivity(), "Not add student detail", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(getActivity(), "add student successfully", Toast.LENGTH_SHORT).show();
                        fname.getEditText().setText(" ");
                        lname.getEditText().setText(" ");
                        email.getEditText().setText(" ");
                        address.getEditText().setText(" ");
                        pincode.getEditText().setText(" ");
                        tootalfee.getEditText().setText(" ");
                        mobile.getEditText().setText(" ");

                    }

                }



            }
        });

        return view;
    }
}