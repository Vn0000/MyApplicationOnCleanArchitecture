package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

class GetShopListUseCase (private val shopListRepository: ShopListRepository) {
    fun getShopList(): List<ShopItam> {
        return shopListRepository.getShopList()
    }
}