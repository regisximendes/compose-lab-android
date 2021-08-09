package com.example.composelab.menu.domain

import android.content.Context
import android.content.Intent
import com.example.composelab.checkout.CheckoutActivity

class CheckoutMenuItem : MenuItem {
    override val title: String = "Checkout"

    override val navigate: (Context) -> Unit = { context ->
        context.startActivity(Intent(context, CheckoutActivity::class.java))
    }
}