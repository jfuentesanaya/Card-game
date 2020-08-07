package com.jfuentes.warofsuits.di

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import com.jfuentes.warofsuits.presentation.viewmodel.MainVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
val useCasesModule = module {

    single { provideUseCase(get())}
    viewModel { MainVM(get()) }
}

private fun provideUseCase(repo: GameRepository): GetSetOfCardsUseCase {
    return GetSetOfCardsUseCase(repo)
}