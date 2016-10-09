package com.bignerdranch.android.addemphasistotext;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mAddEmphasisButton;
    static String[] emphasisOptions = {"Capitalize", "Add Exclaimation Points","Add smiley face"};
    AlertDialog mAlertDialog;
    boolean[] checkedItems = new boolean[emphasisOptions.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.user_input_edit_text);

        mAddEmphasisButton = (Button)findViewById(R.id.add_emphasis_button);
        mAddEmphasisButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                AddEmphasisFragment dialog = AddEmphasisFragment.newInstance("Choose some of these");
//                dialog.show(getFragmentManager(), "What emphasis would you like?");
                mAlertDialog.show();
            }
        });
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Which emphasis would you like?");
        builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int which){
                if (checkedItems[0]){

                    Toast.makeText(getApplicationContext(), emphasisOptions[which], Toast.LENGTH_SHORT).show();
                }
                mAlertDialog = builder.create();
                mAlertDialog.show();
            }
        } );
        builder.setNegativeButton("Cancel",null);
        builder.setMultiChoiceItems(emphasisOptions, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(), emphasisOptions[which], Toast.LENGTH_SHORT).show();
            }
        });
        mAlertDialog=builder.create();

    }
}
