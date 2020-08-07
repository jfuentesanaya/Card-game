package com.jfuentes.warofsuits.domain.model

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
data class Player(
    val name: String,
    var playCardsList: MutableList<Card> = mutableListOf(),
    val discardedCardsList: MutableList<Card>? = mutableListOf()
)