package com.jfuentes.warofsuits.di

import com.jfuentes.warofsuits.presentation.viewmodel.GameVM
import com.jfuentes.warofsuits.presentation.viewmodel.MainVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
val viewModelModule = module {
    viewModel { GameVM(get(), get()) }
    viewModel { MainVM() }
}