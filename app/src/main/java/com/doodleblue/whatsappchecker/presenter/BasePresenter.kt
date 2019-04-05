package com.doodleblue.whatsappchecker.presenter

import android.content.Intent
import com.doodleblue.whatsappchecker.presenter.ipresenter.IPresenter
import com.doodleblue.whatsappchecker.view.iview.IView

abstract class BasePresenter<T : IView>(var iView: T) : IPresenter {


    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
    }

    override fun onStop() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    }

    override fun showToast(message: String) {
        iView.showToast(message)
    }

    override fun showAlertWithMessage(message: String) {
        iView.showAlertWithMessage(message)
    }

    override fun toggleProgress() {
        iView.toggleProgress()
    }
}