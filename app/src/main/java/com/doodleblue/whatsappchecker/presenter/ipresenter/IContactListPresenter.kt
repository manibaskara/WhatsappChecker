package com.doodleblue.whatsappchecker.presenter.ipresenter

interface IContactListPresenter : IPresenter{

    fun setContactListAdapter()
    fun getContacts()
    fun openWhatsApp(toNumber: String?)
    fun isWhatsAppInstalled() : Boolean
}