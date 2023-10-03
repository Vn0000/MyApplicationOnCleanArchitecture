package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.myapplicationoncleanarchitecture.data.ShopListRepositoryImpl
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.DeleteShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.EditShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.GetShopListUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shoplist = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem)
    }
    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }


}