package com.github.faizf.showcaselibrary;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

public class DialogFragmentSample extends DialogFragment {


    public DialogFragmentSample() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View vista = getActivity().getLayoutInflater().inflate(R.layout.dialog_sample, null);

        final TextView sampleTitle = vista.findViewById(R.id.title);
        setCancelable(false);
        builder.setView(vista);
        sampleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCaseUtil.showCase(sampleTitle, getActivity(),
                        R.layout.onboard_sample, sampleTitle.getWidth(), sampleTitle.getHeight(), true, true,
                        DialogFragmentSample.this);
            }
        });


//        builder.setView(vista).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                ShowCaseUtil.showCase(sampleTitle, getActivity(),
//                        R.layout.onboard_sample, sampleTitle.getWidth(), sampleTitle.getHeight(), true, true,
//                        DialogFragmentSample.this);
//            }
//        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                //No code
//            }
//        });
        return builder.create();
    }

}