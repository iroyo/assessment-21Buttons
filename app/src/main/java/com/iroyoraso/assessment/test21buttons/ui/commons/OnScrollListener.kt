package com.iroyoraso.assessment.test21buttons.ui.commons

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
class OnScrollListener(
    private val threshold: Int = 4,
    private val layoutManager: LinearLayoutManager,
    private val triggerNextLoadCallback: () -> Unit
) :
    RecyclerView.OnScrollListener() {

    private var loading = true // True if we are still waiting for the last set of data to load.
    private var total = 0 // The total number of items in the dataset after the last load

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (loading) {
            if (totalItemCount > total) {
                loading = false
                total = totalItemCount
            }
        }
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + threshold) {
            triggerNextLoadCallback()
            loading = true
        }
    }

}
