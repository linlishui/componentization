package com.huitao.common.anotations

/**
 *author  : huitao
 *e-mail  : pig.huitao@gmail.com
 *date    : 2021/5/25 11:26
 *desc    :
 *version :
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ITabPage(val tabName: String, val iconName: String)
