package com.jfuentes.warofsuits.di

import android.app.Application
import androidx.room.Room
import com.jfuentes.warofsuits.data.local.AppDataBase
import com.jfuentes.warofsuits.data.local.CardDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 06/08/2020.
 */

val databaseModule = module {

    single { provideDataBase(androidApplication()) }
    single { provideCardDao(get()) }
}

private fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, AppDataBase::class.java, "cards_database").build()

private fun provideCardDao(database: AppDataBase): CardDao {
    return database.cardDao()
}

