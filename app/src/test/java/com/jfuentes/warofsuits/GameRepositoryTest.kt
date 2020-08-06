package com.jfuentes.warofsuits

import com.jfuentes.warofsuits.data.GameRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryTest {

    private val repo = GameRepositoryImpl()

    @Test
    fun `size of list cards created should be 52`() {
        runBlocking {
            Assert.assertEquals(repo.getSetOfCardsList().size, 52)
        }
    }

    @Test
    fun `size of list cards should be shuffled`() {
        runBlocking {
            val listShuffled = repo.getSetOfCardsListShuffled()
            val listSorted = repo.getSetOfCardsList()

            Assert.assertNotEquals(listShuffled, listSorted)
        }
    }
}