package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.domain.usecase.GetSuitPriorityUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 02/10/2020.
 */
class GetSuitPriorityUseCaseTest {

    private val subject = GetSuitPriorityUseCase()

    @Test
    fun `suit priority should be shuffled`() {
        runBlocking {
            val list1 = subject.getSuitPriority()
            val list2 = subject.getSuitPriority()

            Assert.assertNotEquals(list1, list2)
        }
    }
}