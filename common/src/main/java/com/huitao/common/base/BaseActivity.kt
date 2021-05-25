package com.huitao.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.huitao.common.utils.DataBindingConfig

/**
 *author  : huitao
 *e-mail  : pig.huitao@gmail.com
 *date    : 2021/5/24 10:04
 *desc    :
 *version :
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    private lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBindingConfig = getDataBindingConfig()
        val bind: T = DataBindingUtil.setContentView<T>(this, dataBindingConfig.layout)
        bind.let {
            it.lifecycleOwner = this
            val array = dataBindingConfig.bindingParams
            for (i in 0 until array.size()) {
                it.setVariable(array.keyAt(i), array.valueAt(i))
            }
        }
        mBinding = bind
        initViews()
        initData()
    }


    fun getBinding(): T {
        return mBinding
    }

    abstract fun initViews()
    abstract fun initData()
    abstract fun getDataBindingConfig(): DataBindingConfig

}