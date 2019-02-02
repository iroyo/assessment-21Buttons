package com.iroyoraso.assessment.test21buttons.ui.list

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.data.Game
import com.iroyoraso.assessment.test21buttons.net.ApiProvider

class ListScreen : AppCompatActivity() {

    // VIEWMODEL
    private lateinit var model: ListViewModel

    // ADAPTER
    private val adapter = ListAdapter()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.screen_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        val service = ApiProvider.get(this)
        val factory = ListViewModelFactory(ListViewModelDependencies(service))
        model = ViewModelProviders.of(this, factory).get(ListViewModel::class.java)
        model.retrieveData(result)
    }

    private val result : (List<Game>) -> Unit = {
        adapter.data(it)
    }

}
