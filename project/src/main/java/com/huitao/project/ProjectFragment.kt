package com.huitao.project

import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseFragment
import com.huitao.common.utils.DataBindingConfig
import com.huitao.project.databinding.FragmentProjectBinding

@AutoService(Fragment::class)
@ITabPage(tabName = "项目", iconName = "tab_project")
class ProjectFragment : BaseFragment<FragmentProjectBinding>() {
    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_project)
    }

}