package com.magiclon.bottomsheetdialogdemo

import android.content.pm.ApplicationInfo
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_rvstyle.view.*


class MainActivity : AppCompatActivity() {
    var mData: ArrayList<ApplicationInfo>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apps = packageManager.getInstalledApplications(0)
        mData = ArrayList<ApplicationInfo>()
        // 过滤系统应用
        apps.forEach { action ->
            if ((action.flags and ApplicationInfo.FLAG_SYSTEM) <= 0) {
                mData?.add(action)
            }
        }
        btn_rvstyle.setOnClickListener {
            showRvstyle()
        }
        btn_norvstyle.setOnClickListener {
            showNoRvstyle()
        }
    }


    private fun showRvstyle() {
        var view = LayoutInflater.from(this).inflate(R.layout.bottom_rvstyle, null)
        var recyclerView = view.recycleview
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = InfoAdapter(mData, this)
        recyclerView.adapter = adapter
        var dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()

    }

    private fun showNoRvstyle() {
        var bottomdialog = BottomSheetDialog(this)
        var view = LayoutInflater.from(this).inflate(R.layout.bottom_norvstyle, null)
        bottomdialog.setContentView(view)
        bottomdialog.show()
    }

}
