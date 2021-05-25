package com.huitao.componentization


import androidx.fragment.app.Fragment
import com.huitao.common.anotations.ITabPage
import com.huitao.common.base.BaseActivity
import com.huitao.common.utils.DataBindingConfig
import com.huitao.common.utils.witchContent
import com.huitao.componentization.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTags = ArrayList<String>()
    private lateinit var mCurrentFragment: Fragment
    override fun initViews() {
        loadFragments()
        initBottomEvent()
    }

    private fun initBottomEvent() {
        val menu = getBinding().bottomMenu
        menu.setOnNavigationItemSelectedListener { item ->
            val size: Int = menu.menu.size()
            var index = 0
            for (i in 0 until size) {
                if (menu.menu.getItem(i) === item) {
                    index = i
                    break
                }
            }
            witchContent(
                mCurrentFragment,
                mFragmentList[index],
                mFragmentTags[index],
                R.id.fragment_container
            )
            mCurrentFragment = mFragmentList[index]
            true
        }
    }

    private fun loadFragments() {
        val iterator = ServiceLoader.load(Fragment::class.java)
        val menu = getBinding().bottomMenu.menu
        iterator.forEach { fragment ->
            val property = fragment.javaClass.getAnnotation(ITabPage::class.java) ?: return@forEach
            val menuItem = menu.add(property.tabName)
            menuItem.setIcon(resources.getIdentifier(property.iconName, "mipmap", packageName))
            mFragmentList.add(fragment)
            mFragmentTags.add(property.tabName)
            iterator.iterator()
        }

        if (mFragmentList.isNotEmpty()) {
            mCurrentFragment = mFragmentList.first()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mCurrentFragment, mFragmentTags.first()).commit()
        }
    }

    override fun initData() {
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_main)
    }

}