package com.bignerdranch.android.addemphasistotext;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by miked on 10/11/2016.
 */

public class ResultsFragment extends DialogFragment {
    //listener for the results fragment
    interface ResultsFragmentListener {
    }
    //need to change, but this is how the results fragment gets them from MainActivity
    public static String results;
    public void setResults(String string){
        results = string;
    }
    //reference variable for the listener
    ResultsFragmentListener mResultsFragmentListener;
    //will have arguments eventually that bundles the results string in to them
    public static ResultsFragment newInstance() {
        ResultsFragment fragment = new ResultsFragment();
        return fragment;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //makes sure that the results listener is implemented in MainActivity
        if (activity instanceof ResultsFragmentListener) {
            mResultsFragmentListener = (ResultsFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString() +
                    " must implement ResultsFragmentListener");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //builder for the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set title for dialog   //set the ok button to not do much more than get rid of the dialog
        AlertDialog dialog = builder.setTitle("Your emphasised text is...")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })//set message to be the results of the manipulated text from MainActivity
                .setMessage(results)
                .create();
        return dialog;
    }
}
