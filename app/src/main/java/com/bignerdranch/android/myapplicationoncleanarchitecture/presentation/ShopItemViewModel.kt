package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.myapplicationoncleanarchitecture.data.ShopListRepositoryImpl
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.AddShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.EditShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.GetShopItemUseCase
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItem
import java.util.*

class ShopItemViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)


    fun getShopItem(shopItemId: UUID) {
        val item = getShopItemUseCase.getShopItem(shopItemId)
    }

    fun addShopItemUseCase(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun editShopItemUseCase(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name, count, true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0 // преобразует строку в число и отсекает пробелы
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            // TODO: show error input name
            result = false
        }
        if (count <= 0) {
            // TODO: show error input count
            result = false
        }
        return result
    }

}
