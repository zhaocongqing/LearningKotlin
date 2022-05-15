package com.zcq.learning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zcq.learning.databinding.FragmentMineBinding
import com.zcq.learning.vm.MineViewModel

/**
 * 我的
 * Create by zcq at 5/15/22
 */
class MineFragment: Fragment(){

    private var _binding: FragmentMineBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mineViewModel = ViewModelProvider(this).get(MineViewModel::class.java)
        //初始化binding
        _binding = FragmentMineBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMine
        mineViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}