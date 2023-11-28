package com.example.madoh.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.madoh.R
import com.example.madoh.ui.navigation.Routes.NAV_ACC
import com.example.madoh.ui.navigation.Routes.NAV_HOME
import com.example.madoh.ui.navigation.Routes.NAV_STATS

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: NavItem(R.string.home, R.drawable.ic_home, NAV_HOME)
    object Stats: NavItem(R.string.stats, R.drawable.ic_stats, NAV_STATS)
    object Acc: NavItem(R.string.accounts, R.drawable.ic_acc, NAV_ACC)
}