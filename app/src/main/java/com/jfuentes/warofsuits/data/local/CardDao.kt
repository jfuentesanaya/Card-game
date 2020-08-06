package com.jfuentes.warofsuits.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jfuentes.warofsuits.data.model.CardEntity

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
@Dao
interface CardDao {
    @Query("SELECT * FROM cardentity")
    suspend fun getAll(): List<CardEntity>

    @Insert
    suspend fun insertAll(cards: List<CardEntity>)
}