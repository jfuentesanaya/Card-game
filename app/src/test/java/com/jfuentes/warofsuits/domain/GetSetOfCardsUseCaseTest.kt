package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Suit
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetSetOfCardsUseCaseTest {

    private val gameRepository =  mockk<GameRepository>()
    private val subject =
        GetSetOfCardsUseCase(
            gameRepository
        )

    @Test
    fun `set card should be split on two lists`() {
        runBlocking {

            coEvery { gameRepository.getSetOfCardsListShuffled() } returns listOf(
                Card(2, Suit.HEARTS),
                Card(7, Suit.SPADES),
                Card(12, Suit.DIAMONDS),
                Card(4, Suit.SPADES)
            )
            val listCardsSplit = subject.getSetOfCardsSplit()
            val list1 = listCardsSplit.first()
            val list2 = listCardsSplit.last()

            Assert.assertEquals(list1.size, 2)
            Assert.assertEquals(list2.size, 2)
            Assert.assertEquals(listCardsSplit.size, 2)
        }
    }
}