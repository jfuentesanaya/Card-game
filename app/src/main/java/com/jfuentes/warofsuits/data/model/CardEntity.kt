package com.jfuentes.warofsuits.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
@Entity(primaryKeys= [ "number", "suit" ] )
data class CardEntity(
    @ColumnInfo(name = "number") val num: Int,
    @ColumnInfo(name = "suit") val suit: String
)
