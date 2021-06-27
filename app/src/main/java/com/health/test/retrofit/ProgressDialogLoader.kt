package com.health.test.retrofit

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context


/**
 * Created by Jaison
 */
class ProgressDialogLoader(var context: Context) {
    private var pd: ProgressDialog? = null
    var activity: Activity
    fun progress_dialog_dismiss() {
        if (pd != null && pd!!.isShowing) pd!!.dismiss()
        pd = null
    }

    fun progress_dialog_creation() {
        try {
            if (pd == null) pd = ProgressDialog.show(activity, "", "Loading", true)
        } catch (e: Exception) {
        }
    }

    companion object {
        private var progressDialog: ProgressDialog? = null
        fun progressDialogCreation(activity: Context?, title: String?) {
            try {
                if (progressDialog == null) progressDialog = ProgressDialog.show(activity, "", title, true)
            } catch (e: Exception) {
            }
        }

        fun progressdialogDismiss() {
            if (progressDialog != null && progressDialog!!.isShowing) progressDialog!!.dismiss()
            progressDialog = null
        }
    }

    init {
        activity = context as Activity
    }
}