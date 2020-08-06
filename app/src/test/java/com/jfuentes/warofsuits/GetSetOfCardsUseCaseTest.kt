package com.jfuentes.warofsuits

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.GetSetOfCardsUseCase
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetSetOfCardsUseCaseTest {

    private val gameRepository =  mockk<GameRepository>()
    private val subject =  GetSetOfCardsUseCase(gameRepository)

    @Test
    fun `suit priority should be shuffled`() {
        runBlocking {
            val list1 = subject.getSuitPriority()
            val list2 = subject.getSuitPriority()

            Assert.assertNotEquals(list1, list2)
        }
    }
}