package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class GetShopItemUseCase (private val shopListRepository: ShopListRepository)  {
    fun getShopItem(shopItemId: Int): ShopItam{
        return shopListRepository.getShopItem(shopItemId)
    }
}