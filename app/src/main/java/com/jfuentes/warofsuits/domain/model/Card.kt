package com.jfuentes.warofsuits.domain.model

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
data class Card constructor(val number: Int, val suit: Suit){

    init {
        when {
            number < 2 || number > 14 -> throw NumberFormatException("This card can't be created. Number cards should be from 2 to 14")
            !Suit.hasValidType(suit.suitType) -> throw IllegalArgumentException("This card can't be created. Suit types are: " + Suit.values().toString())
        }
    }


    override fun toString(): String {
        return when(number){
            11 -> "J $suit"
            12 -> "Q $suit"
            13 -> "K $suit"
            14 -> "A $suit"
            else -> "$number $suit"
        }
    }
}


enum class Suit (internal val suitType:String){
    CLUBS("CLUBS"),
    DIAMONDS("DIAMONDS"),
    HEARTS("HEARTS"),
    SPADES("SPADES");

    companion object {
        private val map = values().associateBy(Suit::suitType)
        fun hasValidType(suitType: String) = map[suitType] != null
    }
}