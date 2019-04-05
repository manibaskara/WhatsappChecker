package com.doodleblue.whatsappchecker.adapter

import android.view.ViewGroup
import com.doodleblue.whatsappchecker.R
import com.doodleblue.whatsappchecker.adapter.listener.BaseRecyclerAdapterListener
import com.doodleblue.whatsappchecker.adapter.listener.ContactListListener
import com.doodleblue.whatsappchecker.adapter.viewholder.ContactListViewHolder
import com.doodleblue.whatsappchecker.databinding.InflateContactBinding
import com.doodleblue.whatsappchecker.model.dto.Contact

class ContactListAdapter (data : MutableList<Contact>,
                            var listener: BaseRecyclerAdapterListener<Contact>):
    BaseRecyclerAdapter<Contact, ContactListViewHolder>(data) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {

        return ContactListViewHolder(inflateDataBinding(R.layout.inflate_contact, parent) as InflateContactBinding, listener)
    }
}