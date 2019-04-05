package com.doodleblue.whatsappchecker.model.imodel

import android.content.ContentResolver
import com.doodleblue.whatsappchecker.model.dto.Contact

interface IModelRepository {

    fun populateData(): MutableList<Contact>

    fun getContactsList(resolver: ContentResolver): MutableList<Contact>
}