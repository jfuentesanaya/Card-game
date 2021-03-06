package com.jfuentes.warofsuits.presentation.utils

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
object DialogHelper {

    @JvmStatic
    fun Context.createDialog(
        @StringRes messageId: Int,
        @StringRes positiveButtonText: Int,
        @StringRes negativeButtonText: Int,
        @StringRes title: Int? = null,
        positiveListener: DialogInterface.OnClickListener?,
        cancelable: Boolean = true
    ): AlertDialog.Builder {
        val dialog = AlertDialog.Builder(this)
            .setMessage(messageId)
            .setCancelable(cancelable)
            .setPositiveButton(positiveButtonText, positiveListener)
            .setNegativeButton(negativeButtonText) { dialog, _ -> dialog.dismiss() }

        if (title != null) {
            dialog.setTitle(title)
        }
        return dialog
    }
}