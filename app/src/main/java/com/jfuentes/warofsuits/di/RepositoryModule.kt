package com.jfuentes.warofsuits.di

import com.jfuentes.warofsuits.data.GameRepositoryImpl
import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.domain.GameRepository
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
val repositoryModule = module {

    single { provideRepo(get()) }
}

private fun provideRepo(cardDao: CardDao): GameRepository {
    return GameRepositoryImpl(cardDao)
}