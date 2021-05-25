package com.huitao.mine


import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseFragment
import com.huitao.common.utils.DataBindingConfig
import com.huitao.mine.databinding.FragmentMineBinding

@AutoService(Fragment::class)
@ITabPage(tabName = "我的",iconName = "tab_mine")
class MineFragment : BaseFragment<FragmentMineBinding>() {
    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_mine)
    }

}