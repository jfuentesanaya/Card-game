package com.jfuentes.warofsuits.di

import android.app.Application
import androidx.room.Room
import com.jfuentes.warofsuits.data.GameRepositoryImpl
import com.jfuentes.warofsuits.data.local.AppDataBase
import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.domain.GameRepository
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 06/08/2020.
 */

val appModule = module {

    single { provideDataBase(get()) }
    single { provideCardDao(get()) }
    single { provideRepo(get()) }
}

private fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, AppDataBase::class.java, "cards_database").build()

private fun provideCardDao(database: AppDataBase): CardDao {
    return database.cardDao()
}

private fun provideRepo(cardDao: CardDao): GameRepository {
    return GameRepositoryImpl(cardDao)
}
