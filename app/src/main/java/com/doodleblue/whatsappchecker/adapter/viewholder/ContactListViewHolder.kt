package com.doodleblue.whatsappchecker.adapter.viewholder

import com.doodleblue.whatsappchecker.adapter.listener.BaseRecyclerAdapterListener
import com.doodleblue.whatsappchecker.adapter.listener.ContactListListener
import com.doodleblue.whatsappchecker.databinding.InflateContactBinding
import com.doodleblue.whatsappchecker.model.dto.Contact

class ContactListViewHolder(view: InflateContactBinding, var listener: BaseRecyclerAdapterListener<Contact>) :
    BaseViewHolder<Contact, InflateContactBinding>(view) {

    override fun populateData(data: Contact) {
        viewDataBinding.data = data
        viewDataBinding.position = adapterPosition
        viewDataBinding.lastPosition = lastItemPosition
        viewDataBinding.listener = listener
    }
}