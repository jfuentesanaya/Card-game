package com.jfuentes.warofsuits.domain.model

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
data class Card constructor(val number: Int, val suit: PokerSuit){

    init {
        when {
            number < 2 || number > 14 -> throw NumberFormatException("This card can't be created. Number cards should be from 2 to 14")
            !PokerSuit.hasValidType(suit.suitType) -> throw IllegalArgumentException("This card can't be created. Suit types are: " + PokerSuit.values().toString())
        }
    }

    override fun toString(): String {
        return number.toCardString() + suit
    }
}

fun Int.toCardString(): String {
    return when (this) {
        11 -> "J"
        12 -> "Q"
        13 -> "K"
        14 -> "A"
        else -> "$this"
    }
}
