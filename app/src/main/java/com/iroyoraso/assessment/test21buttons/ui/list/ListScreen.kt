package com.iroyoraso.assessment.test21buttons.ui.list

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.net.ApiProvider

class ListScreen : AppCompatActivity() {

    private lateinit var model: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_list)

        val service = ApiProvider.get(this)
        val factory = ListViewModelFactory(ListViewModelDependencies(service))
        model = ViewModelProviders.of(this, factory).get(ListViewModel::class.java)
        model.retrieveData()
    }

}
