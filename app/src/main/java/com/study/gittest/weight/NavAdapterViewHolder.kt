package com.study.gittest.weight

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.study.gittest.R
import com.zaaach.transformerslayout.holder.Holder

/**
 * Date:2020/3/14
 * author:lwb
 * Desc:
 */
class NavAdapterViewHolder(itemView: View) : Holder<Nav>(itemView) {

    private var icon: ImageView? = null
    private var text: TextView? = null

    override fun onBind(context: Context?, list: MutableList<Nav>?, data: Nav?, position: Int) {
        if (null == data) return
        text?.text = data.text
        //TODO  设置图片
    }

    override fun initView(itemView: View?) {
        icon = itemView?.findViewById(R.id.iv_menu_icon)
        text = itemView?.findViewById(R.id.tv_menu_text)
    }
}

data class Nav(val icoc: Int, val text: String, val url: String)