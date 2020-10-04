package com.jfuentes.warofsuits.domain.model

/**
 * Created by Juan Fuentes on 04/10/2020.
 */

enum class PokerSuit(internal val suitType: String) : Suit {
    CLUBS("CLUBS"),
    DIAMONDS("DIAMONDS"),
    HEARTS("HEARTS"),
    SPADES("SPADES");

    companion object {
        private val map = values().associateBy(PokerSuit::suitType)
        fun hasValidType(suitType: String) = map[suitType] != null
    }
}