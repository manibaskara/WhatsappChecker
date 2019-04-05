package com.doodleblue.whatsappchecker.presenter.ipresenter

import android.content.Intent
import android.os.Bundle

interface IPresenter{

    fun onCreate(bundle: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onDestroy()

    fun onStop()

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

    fun showToast(message: String)

    fun showAlertWithMessage(message: String)

    fun toggleProgress()


}