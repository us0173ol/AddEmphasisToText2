package com.bignerdranch.android.addemphasistotext;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by miked on 10/7/2016.
 */

public class AddEmphasisFragment extends DialogFragment{

    static String[] options = {"Capitalize", "Add Exclaimation Points", "Add Smiley Face"};
    boolean[] checkedItems = new boolean[options.length];

    interface AddEmphasisFragmentListener {
        void userCheckedCapitalize();

        void userCheckedExclaimationPOints();

        void userCheckedAddSmileyFace();

        void userClickedCancel();

        void userClickedOk();
    }

    AddEmphasisFragmentListener mAddEmphasisFragmentListener;

    private final static String MESSAGE_ARG = "Dialog Message";

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

        if (activity instanceof AddEmphasisFragmentListener) {
            mAddEmphasisFragmentListener = (AddEmphasisFragmentListener) activity;

        } else {
            throw new RuntimeException(activity.toString() +
                    " must implement AddEmphasisFragmentListener");

        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String message = getArguments().getString(MESSAGE_ARG);
        if (message == null) {
            message = "Please select an emphasis";
        }
        AlertDialog dialog = builder.setTitle("What emphasis would you like")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAddEmphasisFragmentListener.userClickedOk();

                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAddEmphasisFragmentListener.userClickedCancel();
                    }
                })
                .setMultiChoiceItems(options, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
//                        switch (which){
//                            case 0: {
//                                mAddEmphasisFragmentListener.userCheckedCapitalize();
//                            }
//                            case 1: {
//                                mAddEmphasisFragmentListener.userCheckedExclaimationPOints();
//                            }
//                            case 2: {
//                                mAddEmphasisFragmentListener.userCheckedAddSmileyFace();
//                            }
//                        }
                        //TODO why can I check from bottom to top but not top to bottom?
                        if (checkedItems[0] && isChecked) {
                            mAddEmphasisFragmentListener.userCheckedCapitalize();
                        }
                        else if (checkedItems[1] && isChecked) {
                            mAddEmphasisFragmentListener.userCheckedExclaimationPOints();
                        }
                        else if (checkedItems[2] && isChecked) {
                            mAddEmphasisFragmentListener.userCheckedAddSmileyFace();
                        }
                    }
                })
                .create();
        return dialog;
    }
}
