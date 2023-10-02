package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItam: ShopItam) {
        shopListRepository.addShopItem(shopItam)
    }
}