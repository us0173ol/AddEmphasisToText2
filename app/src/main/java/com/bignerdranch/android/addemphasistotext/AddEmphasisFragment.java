package com.bignerdranch.android.addemphasistotext;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;


/**
 * Created by miked on 10/7/2016.
 */

public class AddEmphasisFragment extends DialogFragment{
    //String array that is used to correlate each to their respective checkbox
    static String[] options = {"Capitalize", "Add Exclaimation Points", "Add Smiley Face"};
    //sets the length of a boolean array to 3
    boolean[] checkedItems = new boolean[options.length];
    //listener for this fragment
    interface AddEmphasisFragmentListener {

        void userClickedOk(boolean[] checkedItems);
    }
    //variable to reference the listener
    AddEmphasisFragmentListener mAddEmphasisFragmentListener;

    private final static String MESSAGE_ARG = "Dialog Message";
    //newInstance that bundles arguments and returns them to display the dialog with the
    //correct info
    public static AddEmphasisFragment newInstance(String message) {
        AddEmphasisFragment fragment = new AddEmphasisFragment();
        Bundle args = new Bundle();
        args.putString(MESSAGE_ARG, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //makes sure that listener and class are implemented in main activity
        if (activity instanceof AddEmphasisFragmentListener) {
            mAddEmphasisFragmentListener = (AddEmphasisFragmentListener) activity;

        } else {
            throw new RuntimeException(activity.toString() +
                    " must implement AddEmphasisFragmentListener");
        }
    }
    //
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //builder for setting up the dialog and its contents
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = builder.setTitle("What emphasis would you like")//displays text as title
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override//when the user clicks ok, options selected are implemented
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAddEmphasisFragmentListener.userClickedOk(checkedItems);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })//sets up checkboxes for the dialog and determines which is checked
                .setMultiChoiceItems(options, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                })//after all oprtions are set, create and return the dialog as is
                .create();
        return dialog;
    }
}
