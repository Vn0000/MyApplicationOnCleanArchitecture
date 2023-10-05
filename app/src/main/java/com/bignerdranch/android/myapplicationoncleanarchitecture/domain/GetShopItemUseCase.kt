package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import java.util.UUID

class GetShopItemUseCase (private val shopListRepository: ShopListRepository)  {
    fun getShopItem(shopItemId: UUID): ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}