package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.myapplicationoncleanarchitecture.data.ShopListRepositoryImpl
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.DeleteShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.EditShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.GetShopListUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shoplist = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch { deleteShopListUseCase.deleteShopItem(shopItem) }
    }
    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}