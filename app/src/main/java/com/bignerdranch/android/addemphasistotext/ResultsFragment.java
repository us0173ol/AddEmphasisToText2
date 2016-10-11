package com.bignerdranch.android.addemphasistotext;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

/**
 * Created by miked on 10/11/2016.
 */

public class ResultsFragment extends DialogFragment {

    interface ResultsFragmentListener {

    }
    public static String results;
    public void setResults(String string){
        results = string;
    }

    ResultsFragmentListener mResultsFragmentListener;

    public static ResultsFragment newInstance() {
        ResultsFragment fragment = new ResultsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ResultsFragmentListener) {
            mResultsFragmentListener = (ResultsFragmentListener) activity;

        } else {
            throw new RuntimeException(activity.toString() +
                    " must implement ResultsFragmentListener");

        }


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = builder.setTitle("Your emphasised text is...")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setMessage(results)
                .create();

        return dialog;
    }


}
