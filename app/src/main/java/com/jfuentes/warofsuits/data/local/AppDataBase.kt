package com.jfuentes.warofsuits.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jfuentes.warofsuits.data.model.CardEntity

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
@Database(entities = [CardEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cardDao(): CardDao

}