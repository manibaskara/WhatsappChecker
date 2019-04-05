package com.doodleblue.whatsappchecker.adapter.listener

interface BaseRecyclerAdapterListener<T> {
    fun onClickItem(position: Int, data: T?)
}