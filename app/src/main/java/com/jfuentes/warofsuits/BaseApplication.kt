package com.jfuentes.warofsuits

import android.app.Application
import com.jfuentes.warofsuits.di.databaseModule
import com.jfuentes.warofsuits.di.repositoryModule
import com.jfuentes.warofsuits.di.useCasesModule
import com.jfuentes.warofsuits.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(databaseModule, repositoryModule, useCasesModule, viewModelModule)
        }
    }

}