package com.iroyoraso.assessment.test21buttons.ui.list.screen

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.Window
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.core.entities.GameData
import com.iroyoraso.assessment.test21buttons.net.ApiProvider
import com.iroyoraso.assessment.test21buttons.ui.commons.OnScrollListener
import com.iroyoraso.assessment.test21buttons.ui.detail.screen.InfoDetailScreen
import com.iroyoraso.assessment.test21buttons.ui.list.presentation.FactoryViewModel
import com.iroyoraso.assessment.test21buttons.ui.list.presentation.ListViewModel
import com.iroyoraso.assessment.test21buttons.ui.list.presentation.ListViewModelDependencies

class ListScreen : AppCompatActivity() {

    // VIEWMODEL
    private lateinit var model: ListViewModel

    // VIEW
    private lateinit var mainProgress: ContentLoadingProgressBar
    private lateinit var loadingProgress: ContentLoadingProgressBar

    // ADAPTER
    private val adapter = ListAdapter { view, data ->
        val intent = Intent(this, InfoDetailScreen::class.java)
        intent.putExtra(InfoDetailScreen.EXTRA_FOR_GAME_ID, data.id)
        intent.putExtra(InfoDetailScreen.EXTRA_FOR_GAME_NAME, data.name)
        intent.putExtra(InfoDetailScreen.EXTRA_FOR_GAME_COVER, data.coverLarge)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageView = view.findViewById<View>(R.id.imageCover)
            val p1 = Pair.create(imageView, data.id)
            // ADD NavigationBar TO THE TRANSITION TO AVOID OVERLAY WITH THE PARTIALLY VISIBLE ITEMS
            val navigationBar = findViewById<View>(android.R.id.navigationBarBackground)
            val p2 = Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2)
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.screen_list)
        setRecyclerView()

        title = getString(R.string.list_game_title)
        loadingProgress = findViewById(R.id.loadingProgress)
        loadingProgress.hide()
        mainProgress = findViewById(R.id.mainProgress)
        mainProgress.show()

        val service = ApiProvider.get(this)
        val factory = FactoryViewModel(ListViewModelDependencies(service))
        model = ViewModelProviders.of(this, factory).get(ListViewModel::class.java)
        model.initialData(onInitialData)
    }

    // SETUP
    private fun setRecyclerView() {
        val layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.number_of_columns))
        val scrollListener = OnScrollListener(4, layoutManager) { loadMore() }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.addOnScrollListener(scrollListener)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun loadMore() {
        loadingProgress.visibility = View.VISIBLE
        loadingProgress.show()
        model.retrieveData(onNewData)
    }


    // CALLBACKS

    private val onInitialData: (List<GameData>) -> Unit = {
        mainProgress.hide()
        adapter.data(it)
    }

    private val onNewData: (List<GameData>) -> Unit = {
        loadingProgress.hide()
        adapter.data(it)
    }

}
