package com.huitao.square

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseFragment
import com.huitao.common.utils.DataBindingConfig
import com.huitao.square.databinding.FragmentSquareBinding

@AutoService(Fragment::class)
@ITabPage(tabName = "广场",iconName = "tab_square")
class SquareFragment : BaseFragment<FragmentSquareBinding>() {
    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_square)
    }

}