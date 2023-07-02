package com.zcq.learning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.zcq.learning.base.BaseFragment
import com.zcq.learning.databinding.FragmentCategoryBinding
import com.zcq.learning.vm.CategoryViewModel

/**
 * 分类
 * Create by zcq at 5/15/22
 */
class CategoryFragment : BaseFragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        //初始化binding
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCategory
        categoryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}