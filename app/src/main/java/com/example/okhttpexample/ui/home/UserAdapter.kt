package com.example.okhttpexample.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.okhttpexample.databinding.CellProfileBinding
import com.example.okhttpexample.models.UserModel

class UserAdapter(private val mList: UserModel): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val binding: CellProfileBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = CellProfileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = mList.data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val individualUser = mList.data[position]
        holder.binding.apply {
            tvEmail.text = individualUser.email
            tvName.text = individualUser.first_name
            Glide.with(ivProfileImage)
                .load(individualUser.avatar)
                .into(ivProfileImage)
        }
    }
}