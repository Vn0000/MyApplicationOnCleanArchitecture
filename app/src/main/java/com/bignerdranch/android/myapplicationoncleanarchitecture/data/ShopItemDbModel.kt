package com.bignerdranch.android.myapplicationoncleanarchitecture.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String,
    val count: Int,
    var enabled: Boolean
)