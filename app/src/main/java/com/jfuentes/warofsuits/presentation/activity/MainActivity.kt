package com.jfuentes.warofsuits.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.databinding.ActivityMainBinding
import com.jfuentes.warofsuits.presentation.viewmodel.MainVM
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainVM by viewModel<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.model = mainVM
        binding.lifecycleOwner = this
    }
}