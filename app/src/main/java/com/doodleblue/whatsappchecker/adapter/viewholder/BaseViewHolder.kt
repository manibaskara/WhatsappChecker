package com.doodleblue.whatsappchecker.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, VB : ViewDataBinding> : RecyclerView.ViewHolder {

    var viewDataBinding: VB

    open var lastItemPosition = 0

    var data: T? = null
    set(value) {
        field = value
        data?.let { populateData(it) }
    }

    internal constructor(viewDataBinding: VB) : super(viewDataBinding.root){
        this.viewDataBinding = viewDataBinding
    }

    abstract fun populateData(data : T)
}