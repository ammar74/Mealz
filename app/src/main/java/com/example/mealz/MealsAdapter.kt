package com.example.mealz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealz.databinding.CategoryItemBinding

class MealsAdapter() : ListAdapter<com.example.domain.entity.Category, MealsAdapter.ViewHolder>(
    CategoryDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: com.example.domain.entity.Category) {
            itemBinding.categoryNameTv.text = category.strCategory
            itemBinding.categoryDescriptionTv.text = category.strCategoryDescription
            Glide.with(itemBinding.root.context).load(category.strCategoryThumb).into(itemBinding.categoryIv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<com.example.domain.entity.Category>() {

        override fun areItemsTheSame(
            oldItem: com.example.domain.entity.Category,
            newItem: com.example.domain.entity.Category
        ): Boolean {
            return oldItem.idCategory==newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: com.example.domain.entity.Category,
            newItem: com.example.domain.entity.Category
        ): Boolean {
            return oldItem == newItem
        }
    }
}