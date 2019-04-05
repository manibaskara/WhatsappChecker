package com.doodleblue.whatsappchecker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.doodleblue.whatsappchecker.adapter.viewholder.BaseViewHolder
import java.lang.IndexOutOfBoundsException

abstract class BaseRecyclerAdapter<T, V : BaseViewHolder<T, *>>(var data: MutableList<T>) : RecyclerView.Adapter<V>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.lastItemPosition = itemCount - 1
        holder.data = getItem(position)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getItem(position: Int): T {
        return data[position]
    }

    fun resetItems(data: MutableList<T>?) {
        if (data != null) {
            this.data = data
            notifyDataSetChanged()
        }
    }

    fun inflateDataBinding(layout : Int, parent: ViewGroup) : ViewDataBinding? {
        return DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }

}