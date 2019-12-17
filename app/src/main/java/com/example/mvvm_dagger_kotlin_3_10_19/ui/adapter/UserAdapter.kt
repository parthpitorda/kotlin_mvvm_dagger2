package com.example.mvvm_dagger_kotlin_3_10_19.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.RawUserBinding
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.Datum
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.PhotosResponse
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.UserResponse
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.PhotoModel
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.UserModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.raw_user.view.*

class UserAdapter(val adapterClick: (Any) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var data: List<PhotosResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RawUserBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.raw_user, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::data.isInitialized) data.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.ivThumb.setOnClickListener {
            adapterClick(
                data[holder.itemView.ivThumb.tag.toString().toInt()].url
            )
        }
    }

    class ViewHolder(private val binding: RawUserBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PhotoModel()

        fun bind(datum: PhotosResponse) {
            viewModel.bind(datum)
            binding.viewModel = viewModel
            binding.ivThumb.tag = viewModel.getId().value
            Picasso.get().load(viewModel.getThumbUrl().value).into(binding.ivThumb)
        }
    }


    fun updateUserList(userList: List<PhotosResponse>) {
        this.data = userList
        notifyDataSetChanged()
    }
}