package com.iroyoraso.assessment.test21buttons.ui.detail.screen

import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.iroyoraso.assessment.test21buttons.R
import com.iroyoraso.assessment.test21buttons.core.entities.RunData
import com.iroyoraso.assessment.test21buttons.core.entities.TimeStats
import com.iroyoraso.assessment.test21buttons.net.ApiProvider
import com.iroyoraso.assessment.test21buttons.ui.detail.presentation.FactoryViewModel
import com.iroyoraso.assessment.test21buttons.ui.detail.presentation.InfoDetailViewModel
import com.iroyoraso.assessment.test21buttons.ui.detail.presentation.InfoDetailViewModelDependencies
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
import android.content.Intent
import android.net.Uri
import android.support.v4.widget.ContentLoadingProgressBar
import com.iroyoraso.assessment.test21buttons.core.entities.UserData
import com.iroyoraso.assessment.test21buttons.ui.commons.setImageFromNetwork

class InfoDetailScreen : AppCompatActivity() {

    // VIEWMODEL
    private lateinit var model: InfoDetailViewModel

    // VIEWS
    private lateinit var textRealTime: TextView
    private lateinit var textIngameTime: TextView
    private lateinit var textPrimaryTime: TextView
    private lateinit var textUserName: TextView
    private lateinit var textUserCountry: TextView
    private lateinit var imageAvatar: ImageView

    private lateinit var buttonVideo: ImageButton

    private lateinit var progressRun: ContentLoadingProgressBar

    companion object {
        const val EXTRA_FOR_GAME_ID = "game_id"
        const val EXTRA_FOR_GAME_NAME = "game_name"
        const val EXTRA_FOR_GAME_COVER = "game_cover"
    }

    override fun onResume() {
        super.onResume()
        progressRun.hide()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_info_detail)
        val gameId = intent.getStringExtra(EXTRA_FOR_GAME_ID)
        val gameName = intent.getStringExtra(EXTRA_FOR_GAME_NAME)
        setCoverHero(gameId)

        progressRun = findViewById(R.id.progressRun)
        textRealTime = findViewById(R.id.textRealTime)
        textIngameTime = findViewById(R.id.textIngameTime)
        textPrimaryTime = findViewById(R.id.textPrimaryTime)

        textUserName = findViewById(R.id.textUserName)
        textUserCountry = findViewById(R.id.textUserCountry)

        imageAvatar = findViewById(R.id.imageAvatar)
        buttonVideo = findViewById(R.id.buttonVideo)

        title = gameName
        progressRun.show()
        val service = ApiProvider.get(this)
        val factory = FactoryViewModel(InfoDetailViewModelDependencies(service))
        model = ViewModelProviders.of(this, factory).get(InfoDetailViewModel::class.java)
        model.retrieveRuns(gameId, onRunResult)
    }

    private fun setCoverHero(gameId: String) {
        supportPostponeEnterTransition()
        val uri = intent.getStringExtra(EXTRA_FOR_GAME_COVER)
        val imageView = findViewById<ImageView>(R.id.imageCoverHero)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) imageView.transitionName = gameId

        Picasso.get().load(uri).into(imageView, object : Callback {
            override fun onError(e: Exception?) {
                supportStartPostponedEnterTransition()
            }

            override fun onSuccess() {
                supportStartPostponedEnterTransition()
            }
        })
    }

    private fun assignTime(textView: TextView, stats: TimeStats?) {
        if (stats != null) {
            textView.text = getString(R.string.time, stats.hours, stats.minutes, stats.seconds)
        } else {
            textView.text = getString(R.string.no_data)
        }
    }

    // CALLBAKS
    private val onRunResult: (RunData) -> Unit = {
        progressRun.hide()

        // GET DATA FROM PLAYER
        if (it.idPlayer != null) {
            model.getUser(it.idPlayer, onUserResult)
        }

        assignTime(textRealTime, it.realTime)
        assignTime(textIngameTime, it.ingameTime)
        assignTime(textPrimaryTime, it.primaryTime)
        val uriVideo = it.uriVideo
        if (uriVideo != null) {
            buttonVideo.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uriVideo))
                startActivity(browserIntent)
            }
        } else {
            buttonVideo.isEnabled = false
        }
    }

    private val onUserResult : (UserData) -> Unit = {
        val uri = "https://www.speedrun.com/themes/user/${it.name}/image.png"
        imageAvatar.setImageFromNetwork(uri)
        textUserName.text = it.name
        when {
            it.region != null -> textUserCountry.text = it.region
            it.country != null -> textUserCountry.text = it.country
            else -> textUserCountry.text = getString(R.string.no_data)
        }
    }

}
