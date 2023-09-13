package com.example.uiassignment4

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.app.SearchManager
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar


class Toolbar_Search_Spiner : AppCompatActivity() {


    var listView1: ListView? = null
    var list: ArrayList<String>? = null
    var adapter: ArrayAdapter<String>? = null
    private var toolbar: Toolbar? = null
    private val category: Array<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_search_spiner)
        listView1 = findViewById(R.id.listView)
        list = ArrayList()
        list!!.add("Apple")
        list!!.add("Banana")
        list!!.add("Pineapple")
        list!!.add("Orange")
        list!!.add("Lychee")
        list!!.add("Gavava")
        list!!.add("Peech")
        list!!.add("Melon")
        list!!.add("Watermelon")
        list!!.add("Papaya")
        adapter = ArrayAdapter(this@Toolbar_Search_Spiner, android.R.layout.simple_list_item_1, list!!)
//        listView1.adapter(adapter)
        val category = resources.getStringArray(R.array.category)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
       // toolbar.setLogo(R.drawable.ic_drawer)
        val spinnerAdapter = ArrayAdapter.createFromResource(applicationContext, R.array.category, R.layout.spinner_dropdown)
        val navigationSpinner = Spinner(supportActionBar?.themedContext)
        navigationSpinner.adapter = spinnerAdapter

        toolbar!!.addView(navigationSpinner, 0)
        navigationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    //Toast.makeText(this, "you selected: " + category[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchViewItem = menu.findItem(R.id.menu1)
        val searchView = searchViewItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.filter?.filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}
