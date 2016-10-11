package com.bignerdranch.android.addemphasistotext;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements AddEmphasisFragment.AddEmphasisFragmentListener,
    ResultsFragment.ResultsFragmentListener{
    String result;
    private EditText mEditText;
    static String[] emphasisOptions = {"Capitalize", "Add Exclaimation Points","Add smiley face"};
    AlertDialog mAlertDialog;
    boolean[] checkedItems = new boolean[emphasisOptions.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.user_input_edit_text);

        Button showEmphasis = (Button)findViewById(R.id.add_emphasis_button);
        showEmphasis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AddEmphasisFragment dialog = AddEmphasisFragment.newInstance("Emphasis Options");
                dialog.show(getFragmentManager(), "What emphasis would you like?");


            }
        });

    }
    public void userDidNothing(){

    }
    public void userClickedOk() {
        ResultsFragment dialog = ResultsFragment.newInstance();

        dialog.setResults(result);
        dialog.show(getFragmentManager(), "Results");
    }
    public  void userClickedCancel(){
    }
    public void userCheckedCapitalize(){
        ResultsFragment dialog = ResultsFragment.newInstance();
        result = mEditText.getText().toString().toUpperCase();
        dialog.setResults(result);
        //dialog.show(getFragmentManager(), "Results");
        //mEditText.setText(result);

    }

    @Override
    public void userCheckedExclaimationPOints() {
        ResultsFragment dialog = ResultsFragment.newInstance();
        result = mEditText.getText().toString()+"!!!";
        dialog.setResults(result);

    }

    @Override
    public void userCheckedAddSmileyFace() {
        ResultsFragment dialog = ResultsFragment.newInstance();
        result = mEditText.getText().toString()+":)";
        dialog.setResults(result);
    }

    }

