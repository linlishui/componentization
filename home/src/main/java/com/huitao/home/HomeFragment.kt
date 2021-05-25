package com.huitao.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseFragment
import com.huitao.common.utils.DataBindingConfig
import com.huitao.home.databinding.FragmentHomeBinding

@AutoService(Fragment::class)
@ITabPage(tabName = "首页", iconName = "tab_home")
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_home)
    }

}