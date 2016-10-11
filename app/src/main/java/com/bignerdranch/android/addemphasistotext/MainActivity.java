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

public class MainActivity extends AppCompatActivity implements
        AddEmphasisFragment.AddEmphasisFragmentListener,
        ResultsFragment.ResultsFragmentListener {
    //global variables
    String result;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.user_input_edit_text);

        Button showEmphasis = (Button) findViewById(R.id.add_emphasis_button);
        //when button is clicked, show dialog with emphasis options
        showEmphasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddEmphasisFragment dialog = AddEmphasisFragment.newInstance("Emphasis Options");
                dialog.show(getFragmentManager(), "What emphasis would you like?");
            }
        });
    }
    /*when the user clicks ok, the method connected to each checkbox is called based on
    * whether that checkbox is checked or not.  Sends that string to the results fragment
    * and displays them*/
    public void userClickedOk(boolean[] checkedItems) {
        ResultsFragment dialog = ResultsFragment.newInstance();
        result = mEditText.getText().toString();
        if (checkedItems[0]) {
            result = result.toUpperCase();
        }
        if (checkedItems[1]) {
            result += "!!!";
        }
        if (checkedItems[2]) {
            result += ":)";
        }
        dialog.setResults(result);
        dialog.show(getFragmentManager(), "Results");
    }

}

