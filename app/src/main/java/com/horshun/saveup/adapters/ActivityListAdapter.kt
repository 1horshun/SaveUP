package com.horshun.saveup.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.horshun.core.domain.models.ActivityDomain
import com.horshun.saveup.R
import com.horshun.saveup.databinding.ItemsActivityUserBinding
import com.horshun.saveup.utils.toCurrencyFormat

class ActivityListAdapter(private val clickListener: (ActivityDomain) -> Unit) :
    ListAdapter<ActivityDomain, ActivityListAdapter.ActivityListViewHolder>(DiffCallback) {

    class ActivityListViewHolder(
        private var binding: ItemsActivityUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activityData: ActivityDomain) {
            with(binding) {
                tvActivityDate.text = activityData.date
                tvActivityItems.text = activityData.name
                if (activityData.isExpense) {
                    imgCategories.setImageResource(R.drawable.ic_arrow_drop_down)
                    tvActivityTotal.text = itemView.context.getString(
                        R.string.rp_placeholder_expense,
                        activityData.amount.toCurrencyFormat()
                    )
                } else {
                    imgCategories.setImageResource(R.drawable.ic_arrow_up)
                    tvActivityTotal.text =
                        itemView.context.getString(
                            R.string.rp_placeholder_income,
                            activityData.amount.toCurrencyFormat()
                        )
                }
            }

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ActivityDomain>() {
        override fun areItemsTheSame(oldItem: ActivityDomain, newItem: ActivityDomain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ActivityDomain, newItem: ActivityDomain): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActivityListViewHolder(
            ItemsActivityUserBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActivityListViewHolder, position: Int) {
        val activityData = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener(activityData)
        }
        holder.bind(activityData)
    }
}