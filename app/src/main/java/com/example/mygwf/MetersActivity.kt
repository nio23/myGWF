package com.example.mygwf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MetersActivity : AppCompatActivity() {

    lateinit var viewModel: MetersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meters)
        val apiClient =  ApiClient()
        val session = SessionManager(this)
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.metersRecycle)
        viewModel = ViewModelProvider(this, ViewModelFactory(Repository(apiClient = apiClient, session= session))).get(MetersViewModel::class.java)
        viewModel.getAllMeters()


        recyclerView.adapter = MetersAdapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.allMetersResponse.observe(this, Observer { response->
            recyclerView.adapter = MetersAdapter(response)



        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.meters_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.search_item-> {
                searchView(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun searchView(item: MenuItem){
        val searchview = item?.actionView as androidx.appcompat.widget.SearchView

        searchview.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    //viewModel.search(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                
                return true
            }

        })

    }
}