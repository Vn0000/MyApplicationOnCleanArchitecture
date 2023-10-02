package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

interface ShopListRepository {
    fun addShopItem(shopItam: ShopItam)
    fun deleteShopItem (shopItam: ShopItam)
    fun editShopItem(shopItem: ShopItam)
    fun getShopItem(shopItemId: Int): ShopItam
    fun getShopList(): List<ShopItam>
}