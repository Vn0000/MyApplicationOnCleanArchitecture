package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItam) {
        shopListRepository.editShopItem(shopItem)
    }
}