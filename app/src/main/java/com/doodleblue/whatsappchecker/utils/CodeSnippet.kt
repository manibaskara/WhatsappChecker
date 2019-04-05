package com.doodleblue.whatsappchecker.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Button
import com.doodleblue.whatsappchecker.R

class CodeSnippet(private val mContext: Context) {

    fun showAlertWithMessage(message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(mContext)
        builder.setCancelable(true)
        builder.setTitle(mContext.resources.getString(R.string.alert_title))
        builder.setMessage(message)
        builder.setPositiveButton(mContext.resources.getString(R.string.install), null)
        builder.setNegativeButton(mContext.resources.getString(R.string.cancel), null)
        val dialog = builder.create()
        dialog.setOnShowListener {
            val buttonPositive: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            buttonPositive.setOnClickListener {
                dialog?.dismiss()
            }
            val buttonNegative: Button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
            buttonNegative.setOnClickListener {
                dialog?.dismiss()
            }
        }
        dialog.show()
    }

    fun showPlayStoreWhatsApp(message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(mContext)
        builder.setCancelable(true)
        builder.setTitle(mContext.resources.getString(R.string.alert_title))
        builder.setMessage(message)
        builder.setPositiveButton(mContext.resources.getString(R.string.install), null)
        builder.setNegativeButton(mContext.resources.getString(R.string.cancel), null)
        val dialog = builder.create()
        dialog.setOnShowListener {
            val buttonPositive: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            buttonPositive.setOnClickListener {
                dialog?.dismiss()
                try {
                    mContext.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp")))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            val buttonNegative: Button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
            buttonNegative.setOnClickListener {
                dialog?.dismiss()
            }
        }
        dialog.show()
    }

}