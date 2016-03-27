package com.vanjiii.faceme.managers;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.vanjiii.faceme.R;

/**
 * Class that handles the dialogs in the application.
 * <p>
 * Created by vanjiii on 3/20/16.
 */
public class DialogManager {

    private ProgressDialog progressDialog;
    private Dialog dialog;

    public DialogManager() {

    }

    /**
     * Start progress dialog.
     *
     * @param context The current context;
     */
    public void showProgressDialog(Context context) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        } else {
            progressDialog.dismiss();
        }

        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(context.getString(R.string.progress_bar_message));
        progressDialog.show();
    }

    /**
     * Dismiss the progress dialog.
     */
    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    /**
     * Display dialog with one Button and custom handler.
     *
     * @param context              The context of the visible activity;
     * @param messageResourceId    String located in the resource file for message;
     * @param buttonTextResourceId String located in the resource file for the button;
     * @param handler              Custom handler; default - dismisses the dialog;
     */
    public void showSingleButtonDialog(Context context, int messageResourceId, int buttonTextResourceId, final View
            .OnClickListener handler) {
        String message = context.getString(messageResourceId);
        String buttonMessage = context.getString(buttonTextResourceId);

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_single_button);
        Button confirmButton = (Button) dialog.findViewById(R.id.confirm_button);
        TextView messageTextView = (TextView) dialog.findViewById(R.id.message_text_view);
        confirmButton.setText(buttonMessage);
        messageTextView.setText(message);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handler != null) {
                    handler.onClick(v);
                }
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
            }
        });
        dialog.show();
    }

    /**
     * Display dialog with one Button.
     *
     * @param context              The context of the visible activity;
     * @param messageResourceId    String located in the resource file for message;
     * @param buttonTextResourceId String located in the resource file for the button;
     */
    public void showSingleButtonDialog(Context context, int messageResourceId, int buttonTextResourceId) {
        showSingleButtonDialog(context, messageResourceId, buttonTextResourceId, null);
    }

    /**
     * Display dialog with two buttons and custom handlers of every button.
     *
     * @param context                      The context of the visible activity;
     * @param messageResourceId            String located in the resource file for message;
     * @param positiveButtonTextResourceId String located in the resource file for the positive button;
     * @param negativeButtonTextResourceId String located in the resource file for the negative button;
     * @param positiveButtonHandler        Custom positive handler; default - dismisses the dialog;
     * @param negativeButtonHandler        Custom negative handler; default - dismisses the dialog;
     */
    public void showTwoButtonsDialog(Context context, int messageResourceId, int positiveButtonTextResourceId, int
            negativeButtonTextResourceId, final View.OnClickListener positiveButtonHandler, final View.OnClickListener
                                             negativeButtonHandler) {
        String message = context.getString(messageResourceId);
        String positiveButtonText = context.getString(positiveButtonTextResourceId);
        String negativeButtonText = context.getString(negativeButtonTextResourceId);

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialod_two_buttons);
        TextView messageTextView = (TextView) dialog.findViewById(R.id.message_text_view);
        messageTextView.setText(message);
        Button positiveButton = (Button) dialog.findViewById(R.id.positive_button);
        positiveButton.setText(positiveButtonText);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positiveButtonHandler != null) {
                    positiveButtonHandler.onClick(v);
                }
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
            }
        });
        Button negativeButton = (Button) dialog.findViewById(R.id.negative_button);
        negativeButton.setText(negativeButtonText);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (negativeButtonHandler != null) {
                    negativeButtonHandler.onClick(v);
                }
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
            }
        });
        dialog.show();
    }

    /**
     * Display dialog with two buttons and custom handler for the positive one.
     *
     * @param context                      The context of the visible activity;
     * @param messageResourceId            String located in the resource file for message;
     * @param positiveButtonTextResourceId String located in the resource file for the positive button;
     * @param negativeButtonTextResourceId String located in the resource file for the negative button;
     * @param positiveHandler              Custom positive handler; default - dismisses the dialog;
     */
    public void showTwoButtonsDialog(Context context, int messageResourceId, int positiveButtonTextResourceId, int
            negativeButtonTextResourceId, View.OnClickListener positiveHandler) {
        showTwoButtonsDialog(context, messageResourceId, positiveButtonTextResourceId, negativeButtonTextResourceId,
                positiveHandler, null);
    }
}
