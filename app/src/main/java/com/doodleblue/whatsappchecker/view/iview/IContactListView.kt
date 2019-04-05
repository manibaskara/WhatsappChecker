package com.doodleblue.whatsappchecker.view.iview

import android.content.Intent
import android.view.View
import com.doodleblue.whatsappchecker.adapter.ContactListAdapter

interface IContactListView : IView{

    fun setContactAdapter(adapter : ContactListAdapter?)
}