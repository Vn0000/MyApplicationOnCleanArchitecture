package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}