package com.jfuentes.warofsuits.presentation.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.jfuentes.warofsuits.presentation.activity.GameActivity

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class MainVM : ViewModel() {

    fun onClickStartGame(view: View) {
        val intent = GameActivity.getCallingIntent(view.context)
        view.context.startActivity(intent)
    }
}