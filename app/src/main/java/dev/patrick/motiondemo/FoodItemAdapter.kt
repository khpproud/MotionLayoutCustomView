package dev.patrick.motiondemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.patrick.motiondemo.databinding.ItemLayoutBinding
import dev.patrick.motiondemo.model.FoodModel

class FoodItemAdapter : ListAdapter<FoodModel, FoodItemAdapter.FoodItemViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        return FoodItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FoodItemViewHolder private constructor(private val binding: ItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FoodModel) {
            binding.run {
                ivFood.setImageResource(item.imgId)
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvCalories.text = item.calories
                tvRate.text = item.rate
            }
        }

        companion object {
            fun create(parent: ViewGroup): FoodItemViewHolder {
                return FoodItemViewHolder(ItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ))
            }
        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<FoodModel>() {
            override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean =
                oldItem.imgId == newItem.imgId

            override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean =
                oldItem == newItem
        }
    }
}