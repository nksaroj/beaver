@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package net.samystudio.beaver.ui.base.dialog

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.CallSuper
import net.samystudio.beaver.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseDataResultDialog<VM : BaseViewModel> : BaseResultDialog()
{
    @Inject
    protected lateinit var viewModelProvider: ViewModelProvider
    protected lateinit var viewModel: VM
    protected abstract val viewModelClass: Class<VM>

    @CallSuper
    override fun init(savedInstanceState: Bundle?)
    {
        viewModel = viewModelProvider.get(viewModelClass)
    }
}