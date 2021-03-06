package com.jfuentes.warofsuits.presentation.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.databinding.ActivityGameBinding
import com.jfuentes.warofsuits.presentation.utils.DialogHelper.createDialog
import com.jfuentes.warofsuits.presentation.viewmodel.GameVM
import org.koin.android.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private val mainVM by viewModel<GameVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val binding: ActivityGameBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_game)

        binding.model = mainVM
        binding.lifecycleOwner = this
    }

    override fun onBackPressed() {
        this.createDialog(
            R.string.sure,
            R.string.yes,
            R.string.no,
            R.string.exit,
            DialogInterface.OnClickListener { _, _ -> super.onBackPressed() },
            false
        ).show()
    }

    companion object {
        @JvmStatic
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, GameActivity::class.java)
        }
    }
}