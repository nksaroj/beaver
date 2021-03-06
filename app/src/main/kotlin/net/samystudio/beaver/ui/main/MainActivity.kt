package net.samystudio.beaver.ui.main

import android.os.Bundle
import net.samystudio.beaver.R
import net.samystudio.beaver.ui.base.activity.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>()
{
    override val layoutViewRes: Int = R.layout.activity_main
    override val viewModelClass: Class<MainActivityViewModel> = MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?)
    {
        // We set launch screen theme from manifest, we need to get back to our Theme to remove
        // launch screen.
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
    }
}
