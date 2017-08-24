package beyram_ghali.me.androidmvpsample.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by beyram on 22/08/17.
 */

public class Utils {

    /**
     * for formatting date
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return new SimpleDateFormat("MM-dd-yyyy").format(date);
    }

    /**
     * Display AlertDialog
     *
     * @param activity
     * @param title
     * @param message
     */
    public static void showAlert(Activity activity, String title, String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
        builder1.setMessage(message);
        builder1.setTitle(title);
        builder1.setCancelable(false);
        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    /**
     * Display ProgressDialog
     *
     * @param progress
     * @param title
     * @param message
     * @param cancelable
     */
    public static void showProgressDialog(ProgressDialog progress, String title, String message, boolean cancelable) {
        progress.setTitle(title);
        progress.setMessage(message);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(cancelable);
        progress.show();
    }

    /**
     * Display Toast
     *
     * @param context
     * @param text
     * @param duration
     */
    public static void showToast(Context context, String text, int duration) {
        Toast.makeText(context, text, duration).show();
    }


}
