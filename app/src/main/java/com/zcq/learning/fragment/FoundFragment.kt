package com.zcq.learning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.zcq.learning.base.BaseFragment
import com.zcq.learning.databinding.FragmentFoundBinding
import com.zcq.learning.vm.FoundViewModel

/**
 * 发现
 * Create by zcq at 5/15/22
 */
class FoundFragment : BaseFragment() {

    private var _binding: FragmentFoundBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val foundViewModel = ViewModelProvider(this).get(FoundViewModel::class.java)
        //初始化binding
        _binding = FragmentFoundBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFound
        foundViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //添加快捷方式
        binding.textFound.setOnClickListener {
//            activity?.let { it1 -> ShortcutUtils.addShortcut(it1) }
        }

        //第1种写法
        binding.textFound.setOnClickListener {

        }
        //第2种写法
        //第3种写法
        //第4种写法
        //第5种写法
        //第6种写法
        //第7种写法
        //第8种写法

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}