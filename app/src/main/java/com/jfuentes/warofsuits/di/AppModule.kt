package com.jfuentes.warofsuits.di

import android.app.Application
import androidx.room.Room
import com.jfuentes.warofsuits.data.GameRepositoryImpl
import com.jfuentes.warofsuits.data.local.AppDataBase
import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import com.jfuentes.warofsuits.presentation.viewmodel.MainVM
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 06/08/2020.
 */

val appModule = module {

    single { provideDataBase(androidApplication()) }
    single { provideCardDao(get()) }
    single { provideRepo(get()) }
    single { provideUseCase(get())}
    viewModel { MainVM(get()) }
}

private fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, AppDataBase::class.java, "cards_database").build()

private fun provideCardDao(database: AppDataBase): CardDao {
    return database.cardDao()
}

private fun provideRepo(cardDao: CardDao): GameRepository {
    return GameRepositoryImpl(cardDao)
}

private fun provideUseCase(repo: GameRepository): GetSetOfCardsUseCase {
    return GetSetOfCardsUseCase(repo)
}
