package com.huitao.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.huitao.common.utils.DataBindingConfig

/**
 *author  : huitao
 *e-mail  : pig.huitao@gmail.com
 *date    : 2021/5/24 15:42
 *desc    :
 *version :
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    private lateinit var mBinding: T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val datingConfig = getDataBindingConfig()
        val array = datingConfig.bindingParams
        val bind: T =
            DataBindingUtil.inflate(inflater, datingConfig.layout, container, false)
        bind.lifecycleOwner = this
        for (i in 0 until array.size()) {
            bind.setVariable(array.keyAt(i), array.valueAt(i))
        }
        mBinding = bind
        return mBinding.root
    }

    fun getBind(): ViewDataBinding {
        return mBinding
    }

    abstract fun getDataBindingConfig(): DataBindingConfig
}