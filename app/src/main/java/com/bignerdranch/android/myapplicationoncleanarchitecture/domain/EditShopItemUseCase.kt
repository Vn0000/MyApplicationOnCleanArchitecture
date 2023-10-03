package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}