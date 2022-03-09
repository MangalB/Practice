package com.example.practice

import com.example.practice.api.UserModel
import org.junit.Assert
import org.junit.Test

class UserTests {

    @Test
    fun is_list_reversed() {
        Assert.assertEquals(getDummyUsers().reversed(), getReversedDummyUsers())
    }

    @Test
    fun is_item_excluded_from_list() {
        Assert.assertEquals(getDummyUsers().filterNot { it.id == 2 }, getExcludedDummyUsers())
    }

    @Test
    fun is_list_reversed_and_item_excluded() {
        Assert.assertEquals(getDummyUsers().filterNot { it.id == 2 }.reversed(), getExcludedReversedDummyUsers())
    }

    private fun getExcludedReversedDummyUsers(): List<UserModel> {
        return listOf<UserModel>(
            UserModel(5, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(4, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(3, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(1, "a", "a", UserModel.Address("a"), UserModel.Company("a"))
        )
    }

    private fun getReversedDummyUsers(): List<UserModel> {
        return listOf<UserModel>(
            UserModel(5, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(4, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(3, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(2, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(1, "a", "a", UserModel.Address("a"), UserModel.Company("a"))
        )
    }

    private fun getExcludedDummyUsers(): List<UserModel> {
        return listOf<UserModel>(
            UserModel(1, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(3, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(4, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(5,"a", "a", UserModel.Address("a"), UserModel.Company("a"))
        )
    }

    private fun getDummyUsers(): List<UserModel> {
        return listOf<UserModel>(
            UserModel(1, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(2, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(3, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(4, "a", "a", UserModel.Address("a"), UserModel.Company("a")),
            UserModel(5,"a", "a", UserModel.Address("a"), UserModel.Company("a"))
        )
    }


}