package com.example.managements;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link View_stdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class View_stdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public View_stdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment View_stdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static View_stdFragment newInstance(String param1, String param2) {
        View_stdFragment fragment = new View_stdFragment();
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

    RecyclerView recyclerView;
    StudentsDB_Class dbClass;

    ArrayList<model> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_view_std,container,false);
        recyclerView = view.findViewById(R.id.recycleview_id);
        dbClass = new StudentsDB_Class(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        Cursor cursor = new StudentsDB_Class(getActivity()).showdata();
        while (cursor.moveToNext()) {
            model m = new model(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(4), cursor.getString(3),cursor.getString(5));
            list.add(m);

        }
        MyAdapter myAdapter = new MyAdapter(list,getContext());
        recyclerView.setAdapter(myAdapter);



        return view;
    }
}