package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import androidx.lifecycle.LiveData
import java.util.*

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem (shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: UUID): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}