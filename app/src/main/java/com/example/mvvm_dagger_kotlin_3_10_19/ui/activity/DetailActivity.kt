package com.example.mvvm_dagger_kotlin_3_10_19.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.ActivityDetailBinding
import com.example.mvvm_dagger_kotlin_3_10_19.ui.fragment.OneFragment
import com.example.mvvm_dagger_kotlin_3_10_19.ui.fragment.SecondFragment
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var mDataBinding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        Picasso.get().load(intent.getStringExtra("data")).into(mDataBinding.ivThumb)

        mDataBinding.ivThumb.setOnClickListener{
            if (mDataBinding.ivThumb.tag == 1){
                val firstFragment = OneFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, firstFragment)
                transaction.commit()
                mDataBinding.ivThumb.tag = 0
            }else{
                val firstFragment = SecondFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, firstFragment)
                transaction.commit()
                mDataBinding.ivThumb.tag = 1
            }
        }
    }
}