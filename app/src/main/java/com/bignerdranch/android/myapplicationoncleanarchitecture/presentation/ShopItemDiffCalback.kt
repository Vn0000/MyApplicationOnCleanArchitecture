package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import androidx.recyclerview.widget.DiffUtil
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ShopItem

class ShopItemDiffCalback: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}