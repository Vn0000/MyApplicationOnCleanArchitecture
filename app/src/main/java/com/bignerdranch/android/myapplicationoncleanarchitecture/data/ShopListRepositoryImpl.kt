package com.bignerdranch.android.myapplicationoncleanarchitecture.data

import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItam
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItam>()
    private var autoIncrementId = 0
    override fun addShopItem(shopItam: ShopItam) {
        if (shopItam.id == ShopItam.UNDEFINED_ID) {
            shopItam.id = autoIncrementId++
        }
        shopList.add(shopItam)
    }

    override fun deleteShopItem(shopItam: ShopItam) {
        shopList.remove(shopItam)
    }

    override fun editShopItem(shopItem: ShopItam) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItam {
        return shopList.find { it.id == shopItemId }
            ?: throw java.lang.RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItam> {
        return shopList.toList()
    }
}