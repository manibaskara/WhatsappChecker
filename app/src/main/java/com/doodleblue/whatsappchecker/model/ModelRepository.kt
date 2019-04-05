package com.doodleblue.whatsappchecker.model

import android.content.ContentResolver
import android.database.Cursor
import android.provider.ContactsContract
import androidx.annotation.WorkerThread
import com.doodleblue.whatsappchecker.model.dto.Contact
import com.doodleblue.whatsappchecker.model.imodel.IModelRepository

open class ModelRepository :
    IModelRepository {
    override fun populateData(): MutableList<Contact> {
        val contactList: MutableList<Contact> = mutableListOf()
        contactList.add(Contact("Akash", "9641257854"))
        contactList.add(Contact("Sonja Merrill", "9234294314"))
        contactList.add(Contact("Sheri Potts", "9891880404"))
        contactList.add(Contact("Flynn Levine", "9716140268"))
        contactList.add(Contact("Sharron Rivas", "9077777947"))
        contactList.add(Contact("Maritza Butler", "9055378445"))
        contactList.add(Contact("Figueroa Waters", "9175697045"))
        return contactList
    }

    @WorkerThread
    override fun getContactsList(resolver: ContentResolver): MutableList<Contact> {

        val contactsList: MutableList<Contact> = mutableListOf()
        val cursor: Cursor? = resolver.query(
            ContactsContract.Contacts.CONTENT_URI, null, null, null,
            null
        )

        if (cursor?.count!! > 0) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phoneNumber = (cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)
                )).toInt()

                if (phoneNumber > 0) {
                    val cursorPhone = resolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", arrayOf(id), null
                    )

                    if (cursorPhone?.count!! > 0) {
                        while (cursorPhone.moveToNext()) {
                            val phoneNumValue = cursorPhone.getString(
                                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            )
                            contactsList.add(Contact(name, phoneNumValue))
                        }
                    }
                    cursorPhone.close()
                }
            }
        }
        cursor.close()
        return contactsList
    }
}