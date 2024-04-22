package com.bonushub.bytapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bonushub.bytapp.R
import com.bonushub.bytapp.entity.AppModel
import com.bonushub.bytapp.util.AppPreferences.getSelectedClassId
import com.helper.callback.Response


class ClassSelectionAdapter(
    private val context: Context,
    private val items: List<AppModel>,
    private val callback: Response.OnClickListener<AppModel>
) : RecyclerView.Adapter<ClassSelectionAdapter.CommonViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewModel {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.slot_class_selection, parent, false)
        return CommonViewModel(item)
    }

    override fun onBindViewHolder(holder: CommonViewModel, position: Int) {
        val item = items[position]
        holder.tvName.text = item.title
        if (item.id == getSelectedClassId()) {
            holder.mainView.setBackgroundResource(R.drawable.bg_class_selected)
            holder.tvName.setTextColor(Color.WHITE)
        } else {
            holder.mainView.setBackgroundResource(R.drawable.bg_class_default)
            holder.tvName.setTextColor(
                ContextCompat.getColor(
                    context,
                    com.helper.R.color.themeTextColor
                )
            )
        }
        holder.itemView.setOnClickListener { v: View? ->
            callback.onItemClicked(v, item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CommonViewModel constructor(v: View) : RecyclerView.ViewHolder(v) {
        val tvName: TextView
        val mainView: View

        init {
            tvName = v.findViewById(R.id.tv_title)
            mainView = v.findViewById(R.id.main_view)
        }
    }
}