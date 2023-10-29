package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import java.util.UUID

class GetShopItemUseCase (private val shopListRepository: ShopListRepository)  {
    suspend fun getShopItem(shopItemId: UUID): ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}