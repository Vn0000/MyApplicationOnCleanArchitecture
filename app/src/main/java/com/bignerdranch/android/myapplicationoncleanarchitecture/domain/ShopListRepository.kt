package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import androidx.lifecycle.LiveData
import java.util.*

interface ShopListRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem (shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: UUID): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}