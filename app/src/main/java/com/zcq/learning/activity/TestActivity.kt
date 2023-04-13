package com.zcq.learning.activity

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zcq.learning.R
import com.zcq.learning.databinding.ActivityTestBinding
import java.util.*


class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    private var mTimer: Timer? = null
    private var mTimerTask: TimerTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化binding
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView: TextView = binding.tvNumber


        mTimer = Timer()
        mTimerTask = object : TimerTask() {
            override fun run() {
                val animation: Animation =
                    AnimationUtils.loadAnimation(this@TestActivity, R.anim.anim_zoom)
//        animation.repeatCount = -1
//        animation.repeatMode = Animation.REVERSE
                textView.startAnimation(animation)
            }
        }
        mTimer!!.schedule(mTimerTask, 0, 3000)

//        val animation1 = ScaleAnimation(
//            0f, 1.1f, 0f, 1.1f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation1.duration = 1000
//        animation1.repeatCount = -1
//
//        val animation2 = ScaleAnimation(
//            0.9f, 1f, 0.9f, 1f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation2.duration = 500
//        animation2.repeatCount = -1
//        animation2.startOffset = 1000
//
//        val animation3 = ScaleAnimation(
//            1f, 0.9f, 1f, 0.9f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation3.duration = 500
//        animation3.repeatCount = -1
//        animation3.startOffset = 1500
//
//        val animation4 = ScaleAnimation(
//            0.9f, 1f, 0.9f, 1f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation4.duration = 500
//        animation4.repeatCount = -1
//        animation4.startOffset = 2000
//
//        val animation5 = ScaleAnimation(
//            1f, 0.9f, 1f, 0.9f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation5.duration = 500
//        animation5.repeatCount = -1
//        animation5.startOffset = 2500
//
//        val animation6 = ScaleAnimation(
//            0.9f, 1f, 0.9f, 1f,
//            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation6.duration = 500
//        animation6.repeatCount = -1
//        animation6.startOffset = 3000
//
//
//        //组合动画
//        val animationSet = AnimationSet(false)
//        animationSet.addAnimation(animation1)
//        animationSet.addAnimation(animation2)
//        animationSet.addAnimation(animation3)
//        animationSet.addAnimation(animation4)
//        animationSet.addAnimation(animation5)
//        animationSet.addAnimation(animation6)
//
////        animationSet.duration = 3000
//        textView.startAnimation(animationSet)


    }
}