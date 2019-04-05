package com.doodleblue.whatsappchecker.view.iview

import androidx.fragment.app.FragmentActivity
import com.doodleblue.whatsappchecker.utils.CodeSnippet

interface IView {

    val codeSnippet: CodeSnippet

    fun showToast(message: String)

    fun showAlertWithMessage(message: String)

    fun getActivity() : FragmentActivity

    fun checkPermission() : Boolean

    fun toggleProgress()
}