package com.teste.presentation.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teste.R
import com.teste.domain.model.StatementList
import kotlinx.android.synthetic.main.adapter_recents.view.*

class RecentesAdapter(val statements: ArrayList<StatementList>) :
    RecyclerView.Adapter<RecentesAdapter.RecentesViewHolder>() {

    override fun getItemCount(): Int {
        return this.statements.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recents, parent, false)
        val holder = RecentesViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecentesViewHolder, position: Int) {
        val statement = statements.get(position)
        val view = holder.itemView
        with(view) {
            title.text = statement.title
            desc.text = statement.desc
            date.text = statement.date
            value.text = statement.valeuFormatted
        }
    }

    class RecentesViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}