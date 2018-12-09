package com.example.hiroki.listviewproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class OrderCheckDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanseState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("ご注文はこちらでよろしいでしょうか？");
        builder.setTitle("注文確認");
        builder.setPositiveButton("OK", new DialogListener());
        builder.setNegativeButton("NO", new DialogListener());
        AlertDialog dialog = builder.create();
        return dialog;

    }

    private class DialogListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String str = "";

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    str = "ご注文を承りました";
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    str = "ご注文をキャンセルしました";
                    break;
            }
            Toast.makeText(getActivity(), str , Toast.LENGTH_LONG).show();
        }
    }
}
