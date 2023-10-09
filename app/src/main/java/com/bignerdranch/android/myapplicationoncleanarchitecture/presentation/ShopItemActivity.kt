package com.bignerdranch.android.myapplicationoncleanarchitecture.presentation

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.myapplicationoncleanarchitecture.R
import java.util.*

class ShopItemActivity : AppCompatActivity() {

    private var screenMode = MODE_UNKNOWN
    private var shopItemId: UUID? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        parsIntent()
        if (savedInstanceState == null) { // проверяет было ли запущенной активити
            launchRightMode()
        }
    }


    private fun launchRightMode() {
        val fragment = when (screenMode) {
            MODE_EDIT -> shopItemId?.let { ShopItemFragment.newInstanceEditItem(it) }
            MODE_ADD -> ShopItemFragment.newInstanceAddItem()
            else -> throw RuntimeException("Unknown screen mode $screenMode")
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.shop_item_container, fragment) // заменяет элемент
                .commit()
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun parsIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
                throw RuntimeException("Param shop item ID is absent")
            }
            shopItemId = intent.getSerializableExtra(EXTRA_SHOP_ITEM_ID, UUID::class.java)
        }
    }

    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mod"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "edit_mod"
        private const val MODE_ADD = "add_mod"
        private const val MODE_UNKNOWN = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, shopItemId: UUID): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, shopItemId)
            return intent
        }
    }
}