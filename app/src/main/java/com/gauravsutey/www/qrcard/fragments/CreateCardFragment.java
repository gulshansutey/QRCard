package com.qrcard.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qrcard.R;

import java.util.HashMap;


public class CreateCardFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateCardFragment newInstance(String param1, String param2) {
        CreateCardFragment fragment = new CreateCardFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_card, container, false);
    }
    private  EditText  et_title,et_name,et_email,et_phone;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_create=(Button)view.findViewById(R.id.btn_create);
          et_title=(EditText)view.findViewById(R.id.et_title);
        et_name=(EditText)view.findViewById(R.id.et_name);
        et_email=(EditText)view.findViewById(R.id.et_email);
        et_phone=(EditText)view.findViewById(R.id.et_phone);
        btn_create.setOnClickListener(this);
    }

    private HashMap<String,String>data=new HashMap<>();
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_create:
                if (TextUtils.isEmpty(et_title.getText())){
                    Toast.makeText(getContext(), "Enter a title", Toast.LENGTH_SHORT).show();
                    et_title.requestFocus();
                }else if (TextUtils.isEmpty(et_name.getText())){
                    et_name.requestFocus();
                    Toast.makeText(getContext(), "Enter a name", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(et_email.getText())){
                    et_email.requestFocus();
                    Toast.makeText(getContext(), "Enter an email", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(et_phone.getText())){
                    et_phone.requestFocus();
                    Toast.makeText(getContext(), "Enter an email", Toast.LENGTH_SHORT).show();
                }else {
                    data.put("title",et_title.getText().toString());
                    data.put("name",et_name.getText().toString());
                    data.put("email",et_email.getText().toString());
                    data.put("phone",et_phone.getText().toString());
                    Toast.makeText(getContext(), "Done!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
