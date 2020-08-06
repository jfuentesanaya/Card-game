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
    fun `cards list should be shuffled`() {
        runBlocking {
            val originalList = repo.getSetOfCardsList()
            val listShuffled = repo.getSetOfCardsListShuffled()

            Assert.assertNotEquals(originalList, listShuffled)
        }
    }

    @Test
    fun `suit priority should be shuffled`() {
        runBlocking {
            val list1 = repo.getSuitPriority()
            val list2 = repo.getSuitPriority()

            Assert.assertNotEquals(list1, list2)
        }
    }
}