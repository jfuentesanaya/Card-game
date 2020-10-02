package com.jfuentes.warofsuits.di

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.usecase.GetHighestCardUseCase
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import com.jfuentes.warofsuits.domain.usecase.GetSuitPriorityUseCase
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
val useCasesModule = module {

    single { provideSetOfCardsUseCase(get())}
    single { provideHighestCardUseCase() }
    single { provideSuitPriorityUseCase() }
}

private fun provideSetOfCardsUseCase(repo: GameRepository): GetSetOfCardsUseCase {
    return GetSetOfCardsUseCase(repo)
}

private fun provideHighestCardUseCase(): GetHighestCardUseCase {
    return GetHighestCardUseCase()
}

private fun provideSuitPriorityUseCase(): GetSuitPriorityUseCase {
    return GetSuitPriorityUseCase()
}