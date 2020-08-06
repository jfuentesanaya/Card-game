package com.jfuentes.warofsuits.domain.model

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class Card(val number: Int, val suit: Suit){

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
    }
}
