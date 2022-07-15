package com.geekbrains.githubapp

import com.geekbrains.githubapp.data.mock.MockUsersRepoImplDAO
import org.junit.Assert.*
import org.junit.Test

class MockUsersRepoImplDAOTest {

    @Test
    fun mockUsers_NotEmptyList_ReturnsNotNull() {
        assertNotNull(MockUsersRepoImplDAO().getUsersList())
    }

    @Test
    fun mockUsers_CorrectUsersAmount_ReturnsThirteen() {
        assertEquals(MockUsersRepoImplDAO().usersCounter(), 13)
    }

    @Test
    fun mockUsers_IncorrectUsersAmount_ReturnsFifteen() {
        assertNotEquals(MockUsersRepoImplDAO().usersCounter(), 15)
    }

    @Test
    fun mockUsers_FirstUserName_ReturnsFabpot() {
        assertSame(MockUsersRepoImplDAO().getFirstUserName(), "fabpot")
    }
}