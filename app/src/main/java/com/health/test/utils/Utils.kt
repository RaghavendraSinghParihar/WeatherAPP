package com.health.test.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Environment
import androidx.appcompat.app.AlertDialog
import com.health.test.R
import java.io.File
import java.math.BigDecimal
import java.util.*

/**
 * Created by MAHESH on 04-Feb-17.
 */
object Utils {


    fun createFolder() {
        val rootPath = File(Environment.getExternalStorageDirectory().absolutePath, Constants.DOWNLOAD_FOLDER_NAME + Constants.PDF_FOLDER_NAME)
        if (!rootPath.exists()) {
            rootPath.mkdirs()
        }
    }

    fun showAlertExitDialog(ctx: Context, strTitle: String?, strMessage: String?) {
        val builder = AlertDialog.Builder(ctx)
        builder.setTitle(strTitle)
        builder.setMessage(strMessage)

        //String positiveText = getString(R.string.ok);
        builder.setPositiveButton("Ok"
        ) { dialog, which -> // positive button logic
            (ctx as Activity).finish()
        }

        //String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton("Cancel"
        ) { dialog, which ->
            // negative button logic
        }
        val dialog = builder.create()
        // display dialog
        dialog.show()
    }

    fun showDailyAlertDialog(ctx: Context, strTitle: String?, strMessage: String?) {
        val builder = AlertDialog.Builder(ctx, R.style.MyDialogTheme)
        builder.setCancelable(false)
        builder.setTitle(strTitle)
        builder.setMessage(strMessage)
        val positiveText = ctx.getString(R.string.ok)
        builder.setPositiveButton(positiveText
        ) { dialog, which -> // positive button logic
            dialog.dismiss()
        }
        val dialog = builder.create()
        // display dialog
        dialog.show()
    }

    fun checkInternetConnection(ctx: Context): Boolean {
        val connManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mWifi = connManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) // For
        // wifi connection
        val gprs = connManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) // For GPRS
        // Connection
        if (gprs!!.isConnected) {
            return true
        } else if (mWifi!!.isConnected) {
            return true
        }
        return false
        // return true;
    }

    val dayInYear: Int
        get() {
            var dayYear: Int
            val ca1 = Calendar.getInstance()
            val DAY_OF_YEAR = ca1[Calendar.DAY_OF_YEAR]
            println("Day of Year :$DAY_OF_YEAR")
            return DAY_OF_YEAR
        }

    fun isFileExisit(rootPath: File, fileName: String): Boolean {
        var isFileExist = false
        for (f in Objects.requireNonNull(rootPath.listFiles())) {
            if (f.isFile) {
                val name = f.name
                // do whatever you want with filename
                if (name.equals(fileName, ignoreCase = true)) {
                    isFileExist = true
                }
            }
        }
        return isFileExist
    }

    fun dirExists(dir_path: String?): Boolean {
        var ret = false
        val dir = File(dir_path)
        if (dir.exists() && dir.isDirectory) ret = true
        return ret
    }

}