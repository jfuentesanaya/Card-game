package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.PokerSuit
import com.jfuentes.warofsuits.domain.usecase.GetHighestCardUseCase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
@RunWith(Parameterized::class)
class GetHighestCardUseCaseTest(
    private val player1Card: Card,
    private val player2Card: Card,
    private val suitPriority: List<PokerSuit>,
    private val expectedResult: Card
) {

    private val subject = GetHighestCardUseCase()

    @Test
    fun `player with highest card should wins`(){
        val winnerCard = subject.getHighestCard(player1Card, player2Card, suitPriority)
        Assert.assertEquals(winnerCard, expectedResult)
    }

    companion object{
        private val fakeSuitPriorityList = listOf(PokerSuit.DIAMONDS, PokerSuit.HEARTS, PokerSuit.CLUBS, PokerSuit.SPADES)

        @JvmStatic
        @Parameterized.Parameters(name = "Game {index}: {0} vs {1}, wins {3}")
        fun params(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    Card(5, PokerSuit.HEARTS),
                    Card(3, PokerSuit.HEARTS),
                    fakeSuitPriorityList,
                    Card(5, PokerSuit.HEARTS)
                ),
                arrayOf(
                    Card(5, PokerSuit.HEARTS),
                    Card(3, PokerSuit.DIAMONDS),
                    fakeSuitPriorityList,
                    Card(5, PokerSuit.HEARTS)
                ),
                arrayOf(
                    Card(3, PokerSuit.SPADES),
                    Card(8, PokerSuit.HEARTS),
                    fakeSuitPriorityList,
                    Card(8, PokerSuit.HEARTS)
                ),
                arrayOf(
                    Card(2, PokerSuit.DIAMONDS),
                    Card(6, PokerSuit.CLUBS),
                    fakeSuitPriorityList,
                    Card(6, PokerSuit.CLUBS)
                ),
                arrayOf(
                    Card(3, PokerSuit.HEARTS),
                    Card(3, PokerSuit.DIAMONDS),
                    fakeSuitPriorityList,
                    Card(3, PokerSuit.DIAMONDS)
                )
            )

        }
    }
}