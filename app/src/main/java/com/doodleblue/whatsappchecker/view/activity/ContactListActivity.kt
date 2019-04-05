package com.doodleblue.whatsappchecker.view.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.doodleblue.whatsappchecker.R
import com.doodleblue.whatsappchecker.adapter.ContactListAdapter
import com.doodleblue.whatsappchecker.databinding.ActivityContactListBinding
import com.doodleblue.whatsappchecker.presenter.ContactListPresenter
import com.doodleblue.whatsappchecker.presenter.ipresenter.IContactListPresenter
import com.doodleblue.whatsappchecker.view.iview.IContactListView

class ContactListActivity : BaseActivity<ActivityContactListBinding, IContactListPresenter>(), IContactListView {

    override fun getLayoutId(): Int {
        return R.layout.activity_contact_list
    }

    override fun onInitializePresenter(): IContactListPresenter {
        return ContactListPresenter(this)
    }

    override fun setContactAdapter(adapter: ContactListAdapter?) {
        val llManager = LinearLayoutManager(this)
        val rvContact = bViewDataBinding?.rvContacts
        rvContact?.layoutManager = llManager
        rvContact?.adapter = adapter
    }

    override fun toggleProgress() {

        if (bViewDataBinding?.pgLoading?.visibility == View.VISIBLE)
            bViewDataBinding?.pgLoading?.visibility = View.GONE
        else
            bViewDataBinding?.pgLoading?.visibility = View.VISIBLE

    }
}