package com.jfuentes.warofsuits.domain.model

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class Player(val name: String, val playCardsList: List<Card>? = emptyList(), val discardedCardsList: List<Card>? = emptyList()){

}