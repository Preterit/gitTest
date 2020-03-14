package com.study.gittest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.study.gittest.weight.Nav
import com.study.gittest.weight.NavAdapterViewHolder
import com.study.gittest.weight.loadData
import com.zaaach.transformerslayout.TransformersLayout
import com.zaaach.transformerslayout.holder.Holder
import com.zaaach.transformerslayout.holder.TransformersHolderCreator

class HorScrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hor_scr)

        val header = findViewById<TransformersLayout<Nav>>(R.id.transformers)

        header.addOnTransformersItemClickListener { position ->
            Toast.makeText(
                this,
                header.dataList[position].text,
                Toast.LENGTH_SHORT
            ).show()
        }
        header.load(loadData(), object : TransformersHolderCreator<Nav> {
            override fun createHolder(itemView: View?): Holder<Nav> {
                return NavAdapterViewHolder(itemView!!)
            }

            override fun getLayoutId() = R.layout.item_nav_list
        })
    }


}