package com.huitao.common.utils

import android.util.SparseArray
import androidx.lifecycle.ViewModel

/**
 *author  : huitao
 *e-mail  : pig.huitao@gmail.com
 *date    : 2021/5/24 11:20
 *desc    :
 *version :
 */
class DataBindingConfig(layout: Int) {
    var layout: Int = 0

    var bindingParams = SparseArray<Any>()

    init {
        this.layout = layout
    }

    fun addBindParams(variableId: Int, any: Any): DataBindingConfig {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, any)
        }
        return this
    }
}