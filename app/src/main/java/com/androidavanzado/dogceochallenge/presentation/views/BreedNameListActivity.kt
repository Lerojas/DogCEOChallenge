package com.androidavanzado.dogceochallenge.presentation.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.androidavanzado.dogceochallenge.R
import com.androidavanzado.dogceochallenge.di.Injection
import com.androidavanzado.dogceochallenge.presentation.adapter.BreedNameAdapter
import com.androidavanzado.dogceochallenge.presentation.viewmodel.BreedNameListActivityViewModel
import com.androidavanzado.dogceochallenge.presentation.viewmodel.BreedNameViewModelFactory

class BreedNameListActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var breedNameAdapter: BreedNameAdapter
    private lateinit var viewModel: BreedNameListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_name_list)

        initRecyclerView()
        setupViewModel()
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

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this, BreedNameViewModelFactory(Injection.providerBreedNameRepository()))
            .get(BreedNameListActivityViewModel::class.java)

        viewModel.breedListData.observe(this,{
            if(it != null){
                breedNameAdapter.setListData(it,this@BreedNameListActivity)
                breedNameAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this@BreedNameListActivity,"Error in getting dara from Api.", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.getData()
    }

    override fun onItemClickListener(breedName: String) {
        val intent = Intent(this, BreedImageListActivity::class.java).apply {
            putExtra("breedName", breedName)
        }
        startActivity(intent)
    }
}