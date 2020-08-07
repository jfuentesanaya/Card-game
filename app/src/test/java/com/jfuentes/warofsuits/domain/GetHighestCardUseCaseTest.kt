package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Suit
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
    private val suitPriority: List<Suit>,
    private val expectedResult: Card
) {

    private val subject = GetHighestCardUseCase()

    @Test
    fun `player with highest card should wins`(){
        val winnerCard = subject.getHighestCard(player1Card, player2Card, suitPriority)
        Assert.assertEquals(winnerCard, expectedResult)
    }

    companion object{
        private val fakeSuitPriorityList = listOf(Suit.DIAMONDS, Suit.HEARTS, Suit.CLUBS, Suit.SPADES)

        @JvmStatic
        @Parameterized.Parameters(name = "Game {index}: {0} vs {1}, wins {3}")
        fun params(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    Card(5, Suit.HEARTS),
                    Card(3, Suit.HEARTS),
                    fakeSuitPriorityList,
                    Card(5, Suit.HEARTS)
                ),
                arrayOf(
                    Card(5, Suit.HEARTS),
                    Card(3, Suit.DIAMONDS),
                    fakeSuitPriorityList,
                    Card(5, Suit.HEARTS)
                ),
                arrayOf(
                    Card(3, Suit.SPADES),
                    Card(8, Suit.HEARTS),
                    fakeSuitPriorityList,
                    Card(8, Suit.HEARTS)
                ),
                arrayOf(
                    Card(2, Suit.DIAMONDS),
                    Card(6, Suit.CLUBS),
                    fakeSuitPriorityList,
                    Card(6, Suit.CLUBS)
                ),
                arrayOf(
                    Card(3, Suit.HEARTS),
                    Card(3, Suit.DIAMONDS),
                    fakeSuitPriorityList,
                    Card(3, Suit.DIAMONDS)
                )
            )

        }
    }
}