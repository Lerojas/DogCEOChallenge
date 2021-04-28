package com.androidavanzado.dogceochallenge.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.androidavanzado.dogceochallenge.R
import com.androidavanzado.dogceochallenge.adapter.BreedNameAdapter
import com.androidavanzado.dogceochallenge.viewmodels.BreedNameListActivityViewModel

class BreedNameListActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var breedNameAdapter: BreedNameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_name_list)

        initRecyclerView()
        createData()
    }

    private fun initRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@BreedNameListActivity)
            breedNameAdapter = BreedNameAdapter()
            adapter = breedNameAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }

    private fun createData(){

        val viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(BreedNameListActivityViewModel::class.java)
        viewModel.getListDataObserver().observe(this, {
            if(it != null){
                breedNameAdapter.setListData(it,this@BreedNameListActivity)
                breedNameAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this@BreedNameListActivity,"Error in getting dara from Api.", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.makeApiCall()
    }

    override fun onItemClickListener(breedName: String) {
        val intent = Intent(this, BreedImageListActivity::class.java).apply {
            putExtra("breedName", breedName)
        }
        startActivity(intent)
    }
}