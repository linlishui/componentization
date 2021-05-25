package com.huitao.common.utils

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 *author  : huitao
 *e-mail  : pig.huitao@gmail.com
 *date    : 2021/5/25 16:02
 *desc    :
 *version :
 */

fun AppCompatActivity.witchContent(from: Fragment, to: Fragment, tag: String, id: Int) {
    val ft = supportFragmentManager.beginTransaction()
    when (to.isAdded) {
        true -> {
            ft.hide(from).show(to).commit()
        }
        else -> {
            ft.hide(from).add(id, to, tag).commit()
        }
    }
}