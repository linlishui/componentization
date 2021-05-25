package com.huitao.officialaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseFragment
import com.huitao.common.utils.DataBindingConfig
import com.huitao.officialaccount.databinding.FragmentOfficialAccountBinding

@AutoService(Fragment::class)
@ITabPage(tabName = "公众号", iconName = "tab_official_account")
class OfficialAccountFragment : BaseFragment<FragmentOfficialAccountBinding>() {
    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_official_account)
    }

}