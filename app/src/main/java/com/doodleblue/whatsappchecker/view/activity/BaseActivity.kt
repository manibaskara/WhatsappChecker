package com.doodleblue.whatsappchecker.view.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.doodleblue.whatsappchecker.presenter.ipresenter.IPresenter
import com.doodleblue.whatsappchecker.utils.CodeSnippet
import com.doodleblue.whatsappchecker.view.iview.IView

abstract class BaseActivity<B : ViewDataBinding, T : IPresenter> : AppCompatActivity(), IView {


    protected var mCodeSnippet: CodeSnippet? = null
    protected var bViewDataBinding: B? = null
    protected var iPresenter: T? = null
    protected var toast: Toast?=null
    val PERMISSIONS_REQUEST_READ_CONTACTS = 100


    override fun showToast(message: String) {
        toast?.cancel()
        toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun showAlertWithMessage(message: String) {
        codeSnippet?.showAlertWithMessage(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        iPresenter = onInitializePresenter()
        iPresenter!!.onCreate(intent.extras)
    }

    abstract fun getLayoutId(): Int
    abstract fun onInitializePresenter(): T
    override fun getActivity(): FragmentActivity {
        return this@BaseActivity
    }

    override fun checkPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS)
            return false
        } else {
            return true
        }
    }

    override val codeSnippet: CodeSnippet
        get() {
            if (mCodeSnippet == null){
                mCodeSnippet = CodeSnippet(this.getActivity())
                return mCodeSnippet!!
            } else return mCodeSnippet as CodeSnippet
        }
}