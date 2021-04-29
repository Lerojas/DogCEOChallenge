package com.androidavanzado.dogceochallenge.presentation.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.androidavanzado.dogceochallenge.R
import com.androidavanzado.dogceochallenge.di.Injection
import com.androidavanzado.dogceochallenge.presentation.adapter.BreedImageAdapter
import com.androidavanzado.dogceochallenge.presentation.viewmodel.BreedImageListActivityViewModel
import com.androidavanzado.dogceochallenge.presentation.viewmodel.BreedImageViewModelFactory

class BreedImageListActivity : AppCompatActivity() {

    private lateinit var breedImageAdapter: BreedImageAdapter
    private lateinit var viewModel : BreedImageListActivityViewModel
    private lateinit var breedName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_image_list)

        breedName = intent.getStringExtra("breedName").toString()

        initRecyclerView()
        setupViewModel()
    }

    private fun initRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@BreedImageListActivity)
            breedImageAdapter = BreedImageAdapter()
            adapter = breedImageAdapter

            val decoration = DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this, BreedImageViewModelFactory(Injection.providerBreedImageRepository()))
            .get(BreedImageListActivityViewModel::class.java)

        viewModel.breedListData.observe(this,{
            if(it != null){
                breedImageAdapter.setListData(it)
                breedImageAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this@BreedImageListActivity,"Error in getting dara from Api.", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.getData(breedName)
    }
}