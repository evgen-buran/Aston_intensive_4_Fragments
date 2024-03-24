package com.buranchikov.fragmentsastonapp

import androidx.fragment.app.Fragment

interface FragmentsOperationInterface {
    fun showFragment(fragment: Fragment, tagBackStack:String)
    fun getCurrentFragment(currentFragment: Fragment?, tag:String)
}