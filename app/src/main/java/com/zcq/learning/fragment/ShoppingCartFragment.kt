package com.zcq.learning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.zcq.learning.base.BaseFragment
import com.zcq.learning.databinding.FragmentShoppingCartBinding
import com.zcq.learning.vm.ShoppingCartViewModel

/**
 * 购物车
 * Create by zcq at 5/15/22
 */
class ShoppingCartFragment: BaseFragment() {

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val shoppingCartViewModel = ViewModelProvider(this).get(ShoppingCartViewModel::class.java)
        //初始化binding
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textShopping
        shoppingCartViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}