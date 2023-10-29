package com.bignerdranch.android.myapplicationoncleanarchitecture.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItem
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.random.Random

class ShopListRepositoryImpl(
    application: Application
) : ShopListRepository {

    private val coroutine = Dispatchers.IO

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopItem: ShopItem) = withContext(coroutine) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) = withContext(coroutine) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) = withContext(coroutine) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun getShopItem(shopItemId: UUID): ShopItem = withContext(coroutine) {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return@withContext mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> =
        MediatorLiveData<List<ShopItem>>().apply {
            addSource(shopListDao.getShopList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }
}