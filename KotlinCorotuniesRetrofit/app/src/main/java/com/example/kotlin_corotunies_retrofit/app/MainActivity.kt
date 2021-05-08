package com.example.kotlin_corotunies_retrofit.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_corotunies_retrofit.R
import com.example.kotlin_corotunies_retrofit.app.adapter.Adapter
import com.example.kotlin_corotunies_retrofit.data.RetrofitHolder
import com.example.kotlin_corotunies_retrofit.di.DaggerRetrofitComponent
import com.example.kotlin_corotunies_retrofit.domain.AccessData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ArchitectureManager.View {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : Adapter

    val component = DaggerRetrofitComponent.create()

    @Inject
    lateinit var retrofitHolder: RetrofitHolder

    @Inject
    lateinit var accessor : AccessData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)
        initLayout()

        GlobalScope.launch(Main) {
            getData()
            adapter.setList(accessor.getList())
            recyclerView.adapter = adapter
        }

    }

    private suspend fun getData(){
        accessor.getData()
    }

    override fun initLayout() {
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = Adapter()
        adapter.setContext(this)

        //Later ...
    }
}