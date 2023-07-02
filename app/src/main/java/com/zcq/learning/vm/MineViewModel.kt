package com.zcq.learning.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zcq.learning.R
import com.zcq.learning.entity.MineLabelInfo
import com.zcq.learning.entity.UserInfo

/**
 * Create by zcq at 5/15/22
 */
class MineViewModel: ViewModel() {

    //用户信息
    private val _userInfo = MutableLiveData<UserInfo>().apply {
        value = UserInfo("撸码狂","适当撸码，有益身心健康！")
    }
    val userInfo: LiveData<UserInfo> = _userInfo

    // 功能入口信息
    private val _labelList = MutableLiveData<List<MineLabelInfo>>().apply {
        value = listOf(
            MineLabelInfo("每日福利", R.drawable.ic_mine_welfare),
            MineLabelInfo("我的钱包", R.drawable.ic_mine_wallet),
            MineLabelInfo("参与活动", R.drawable.ic_mine_event),
            MineLabelInfo("浏览历史", R.drawable.ic_mine_history),
            MineLabelInfo("身份认证", R.drawable.ic_mine_auth),
            MineLabelInfo("我的评论", R.drawable.ic_mine_comment),
            MineLabelInfo("意见反馈", R.drawable.ic_mine_feedback),
            MineLabelInfo("查看更多", R.drawable.ic_mine_more)
        )
    }
    val labelList: LiveData<List<MineLabelInfo>> = _labelList

}