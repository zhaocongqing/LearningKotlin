package com.zcq.learning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.zcq.learning.adapter.MineLabelAdapter
import com.zcq.learning.base.BaseFragment
import com.zcq.learning.databinding.FragmentMineBinding
import com.zcq.learning.entity.MineLabelInfo
import com.zcq.learning.vm.MineViewModel

/**
 * 我的
 * Create by zcq at 5/15/22
 */
class MineFragment: BaseFragment(), View.OnClickListener{

    private var _binding: FragmentMineBinding? = null
    private val binding get() = _binding!!
    private lateinit var mContext: AppCompatActivity

    private val viewModel: MineViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //初始化binding
        _binding = FragmentMineBinding.inflate(inflater, container, false)
        val root: View = binding.root
        mContext = activity as AppCompatActivity
        val toolbar: Toolbar = binding.toolbar
        val customTitle: TextView = binding.customTitle
        toolbar.title = ""
        mContext.setSupportActionBar(toolbar)
        customTitle.text = "我的"

        //设置用户信息
        setUserInfo()
        //设置功能入口
        setLabelList()
        binding.pointsLay.setOnClickListener(this)
        binding.collectLay.setOnClickListener(this)
        binding.studyLay.setOnClickListener(this)
        binding.findLay.setOnClickListener(this)
        binding.settingLay.setOnClickListener(this)

        return root
    }

    private fun setUserInfo(){
        val userName: TextView = binding.textName
        val userSign: TextView = binding.textSign
        viewModel.userInfo.observe(viewLifecycleOwner) {
            userName.text = it.userName
            userSign.text = it.userSign
        }
    }

    private fun setLabelList(){
        binding.labelList.layoutManager = GridLayoutManager(mContext, 4)
        val labelList: List<MineLabelInfo> = viewModel.labelList.value!!
        val labelAdapter = MineLabelAdapter(labelList)
        binding.labelList.adapter = labelAdapter
        labelAdapter.setOnItemClickListener { _, _, position ->
            showToast("点击了第${position}项")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View) {
        when (v.id){
            binding.pointsLay.id -> {
                showToast("积分")
            }
            binding.collectLay.id -> {
                showToast("收藏")
            }
            binding.studyLay.id -> {
                showToast("学习")
            }
            binding.findLay.id -> {
                showToast("发现")
            }
            binding.settingLay.id -> {
                showToast("设置")
            }
        }
    }
}