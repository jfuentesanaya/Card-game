package com.jfuentes.warofsuits.data

import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.data.model.CardEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryTest {

    private val cardDao = mockk<CardDao>(relaxed = true)
    private val repo = GameRepositoryImpl(cardDao)

    @Test
    fun `should create cards on dao when list is empty`() = runBlocking {
        coEvery { cardDao.getAll() } returns emptyList()
        repo.getSetOfCardsListShuffled()

        coVerify(exactly = 1) { cardDao.insertAll(repo.createSet()) }
    }

    @Test
    fun `should getAll cards of dao when repo is executed`() = runBlocking {
        coEvery { cardDao.getAll() } returns fakeList
        repo.getSetOfCardsListShuffled()

        coVerify(exactly = 1) { cardDao.getAll() }
    }

    @Test
    fun `should map dao object to model when repo is executed`() = runBlocking {
        coEvery { cardDao.getAll() } returns fakeList
        val cardList = repo.getSetOfCardsList()

        Assert.assertEquals(cardList[0].number, fakeList[0].num)
        Assert.assertEquals(cardList[0].suit.suitType, fakeList[0].suit)
    }

    @Test
    fun `cards list should be shuffled`() = runBlocking {
        coEvery { cardDao.getAll() } returns fakeList
        val listShuffled = repo.getSetOfCardsListShuffled()

        Assert.assertNotEquals(fakeList, listShuffled)
    }

    @Test
    fun `list of cards should be 52`() = runBlocking {
        Assert.assertEquals(repo.createSet().size, 52)
    }

    companion object{
        val fakeList = listOf(
            CardEntity(2, "HEARTS"),
            CardEntity(3, "HEARTS"),
            CardEntity(5, "DIAMONDS")
        )
    }
}