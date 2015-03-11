package com.example.br161.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    private EditText etPrimary;
    private EditText etSecondary;
    private TextView tvSolve;
    private LinearLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrimary = (EditText) findViewById(R.id.et_primary);
        etSecondary = (EditText) findViewById(R.id.et_secondary);
        tvSolve = (TextView) findViewById(R.id.tv_solve);
        fragmentContainer = (LinearLayout) findViewById(R.id.fragment_container);

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);

        etPrimary.setText(prefs.getInt("first", -1) + "");
        etSecondary.setText(prefs.getInt("second", -1) + "");

        tvSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SumFragment sumFrag = new SumFragment();
                Bundle bundle = new Bundle();

                int firstValue = Integer.parseInt(etPrimary.getText().toString());
                int secondValue = Integer.parseInt(etSecondary.getText().toString());

                bundle.putInt("primary", firstValue);
                bundle.putInt("secondary", secondValue);

                sumFrag.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, sumFrag)
                        .addToBackStack("")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();

                //save values for next time
                SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putInt("first", firstValue);
                editor.putInt("second", secondValue);

                editor.commit();
            }//end onClick
        });//end tvSolve.setOnClickListener
    }//end method onCreate
}//end class MainActivity
