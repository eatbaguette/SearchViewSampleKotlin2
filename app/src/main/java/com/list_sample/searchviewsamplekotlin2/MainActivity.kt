package com.list_sample.searchviewsamplekotlin2

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null
    private var stringArrayList: ArrayList<String>? = null
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.list_item) as ListView
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        setData()
        adapter = ListViewAdapter(this, R.layout.item_listview, stringArrayList)
        listView!!.adapter = adapter

        listView!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(this@MainActivity, parent.getItemAtPosition(position) as String, Toast.LENGTH_SHORT).show() }
    }

    private fun setData() {
        stringArrayList = ArrayList()
        stringArrayList!!.add("Quynh Trang")
        stringArrayList!!.add("Hoang Bien")
        stringArrayList!!.add("Duc Tuan")
        stringArrayList!!.add("Dang Thanh")
        stringArrayList!!.add("Xuan Luu")
        stringArrayList!!.add("Phan Thanh")
        stringArrayList!!.add("Kim Kien")
        stringArrayList!!.add("Ngo Trang")
        stringArrayList!!.add("Thanh Ngan")
        stringArrayList!!.add("Nguyen Duong")
        stringArrayList!!.add("Quoc Cuong")
        stringArrayList!!.add("Tran Ha")
        stringArrayList!!.add("Vu Danh")
        stringArrayList!!.add("Minh Meo")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val myActionMenuItem = menu.findItem(R.id.action_search)
        val searchView = myActionMenuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (TextUtils.isEmpty(newText)) {
                    adapter!!.filter("")
                    listView!!.clearTextFilter()
                } else {
                    adapter!!.filter(newText)
                }
                return true
            }
        })

        return true
    }
}