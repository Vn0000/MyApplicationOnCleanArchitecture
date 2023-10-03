package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem (shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}