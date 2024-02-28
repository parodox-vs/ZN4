package com.example.praktikakapustnikov

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.example.praktikakapustnikov.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikakapustnikov.dto.Post


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Бтпит. Учебное заведение",
            content = "Всех студентов поздравляем с 1 сентября!",
            published = "1 сентября в 8:00",
            likedByMe = false,
            sharedByMe = false
        )

        with(binding) {
            textView.text = post.author
            textView2.text = post.published
            textView3.text = post.content
            if (post.likedByMe) {
                imageButton?.setImageResource(R.drawable.like_svgrepo_com__1_)
            }
            textView4?.text = post.likes.toString()

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

            imageView.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            imageButton?.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                imageButton.setImageResource(
                    if (post.likedByMe) R.drawable.like_svgrepo_com__1_ else R.drawable.like_svgrepo_com
                )
                if (post.likedByMe) post.likes++ else post.likes--
                textView4?.text = post.likes.toString()
            }

            imageButton2?.setOnClickListener {
                Log.d("stuff", "share")
                post.sharedByMe = !post.sharedByMe
                if (post.sharedByMe) post.shares++
                textView5?.text = post.shares.toString()
            }
        }





        }
    }
