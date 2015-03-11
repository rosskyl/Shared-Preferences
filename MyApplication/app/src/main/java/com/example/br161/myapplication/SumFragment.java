package com.example.br161.myapplication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {

    private TextView tvSum;

    public SumFragment() {
        // Required empty public constructor
    }//end method SumFragment


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum, container, false);
    }//end method onCreateView

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvSum = (TextView) view.findViewById(R.id.tv_sum);

        int firstValue = getArguments().getInt("primary", -1);
        int secondValue = getArguments().getInt("secondary", -1);

        int sum = firstValue + secondValue;

        tvSum.setText(Integer.toString(sum));
    }//end method onViewCreated
}//end class SumFragment
