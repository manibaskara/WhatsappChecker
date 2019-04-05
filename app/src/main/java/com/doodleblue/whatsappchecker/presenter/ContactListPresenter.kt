package com.doodleblue.whatsappchecker.presenter

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import com.doodleblue.whatsappchecker.R
import com.doodleblue.whatsappchecker.adapter.ContactListAdapter
import com.doodleblue.whatsappchecker.adapter.listener.BaseRecyclerAdapterListener
import com.doodleblue.whatsappchecker.model.ModelRepository
import com.doodleblue.whatsappchecker.model.dto.Contact
import com.doodleblue.whatsappchecker.presenter.ipresenter.IContactListPresenter
import com.doodleblue.whatsappchecker.view.iview.IContactListView

class ContactListPresenter(var iContactListView: IContactListView) :
    BasePresenter<IContactListView>(iContactListView),
    IContactListPresenter {


    override fun onCreate(bundle: Bundle?) {
        getContacts()
    }

    var adapter: ContactListAdapter? = null
    var contactsList: MutableList<Contact> = mutableListOf()

    override fun getContacts() {

        //contactsList = ModelRepository().populateData()

        if (iContactListView.checkPermission()) {
            contactsList = ModelRepository().getContactsList(iContactListView.getActivity().contentResolver)
            setContactListAdapter()
            // iContactListView.toggleProgress()
        } else
            showAlertWithMessage(iView.getActivity().getString(R.string.empty_contacts))
        //iContactListView.toggleProgress()

    }

    override fun setContactListAdapter() {
        if (adapter == null) {
            adapter = ContactListAdapter(contactsList, listener)
            iContactListView.setContactAdapter(adapter)
        } else {
            adapter?.notifyDataSetChanged()
        }
    }

    private val listener = object : BaseRecyclerAdapterListener<Contact> {
        override fun onClickItem(position: Int, data: Contact?) {
            if (isWhatsAppInstalled())
                openWhatsApp(data?.phoneNumber)
            else
                iView.codeSnippet.showPlayStoreWhatsApp(iView.getActivity().getString(R.string.whatsapp_not_installed))
        }
    }

    override fun openWhatsApp(toNumber: String?) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber")
            iContactListView.getActivity().startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun isWhatsAppInstalled(): Boolean {
        try {
            iView.getActivity().packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
    }
}