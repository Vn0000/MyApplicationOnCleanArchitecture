package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem (shopItam: ShopItam) {
        shopListRepository.deleteShopItem(shopItam)
    }
}