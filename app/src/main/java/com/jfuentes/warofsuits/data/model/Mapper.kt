package com.jfuentes.warofsuits.data.model

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Suit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
fun CardEntity.toCard() : Card{
    return Card(num, Suit.valueOf(suit))
}

fun Card.toCardEntity() : CardEntity{
    return CardEntity(number, suit.suitType)
}