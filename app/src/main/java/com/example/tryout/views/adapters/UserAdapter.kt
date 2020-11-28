package com.example.tryout.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tryout.databinding.ItemContactBinding
import com.example.tryout.repositories.remote.responses.ResponseCoontact

class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(productModel: ResponseCoontact) {
            binding.run {
                tvName.text = productModel.name
                tvCompany.text = productModel.company
                tvEmail.text = productModel.email
                tvJob.text = productModel.job
                tvPhone.text = productModel.phone

                Glide.with(binding.root).load(productModel.image).into(ivImage)

            }
        }
    }

    var list = mutableListOf<ResponseCoontact>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(

            ItemContactBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size
}
