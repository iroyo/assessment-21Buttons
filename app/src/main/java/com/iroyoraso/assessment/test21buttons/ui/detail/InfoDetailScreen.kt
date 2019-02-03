package com.iroyoraso.assessment.test21buttons.ui.detail

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.iroyoraso.assessment.test21buttons.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class InfoDetailScreen : AppCompatActivity() {

    companion object {
        const val EXTRA_FOR_GAME_ID = "game_id"
        const val EXTRA_FOR_GAME_NAME = "game_name"
        const val EXTRA_FOR_GAME_COVER = "game_cover"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_info_detail)
        supportPostponeEnterTransition()

        val imageView = findViewById<ImageView>(R.id.imageCoverHero)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.transitionName = intent.getStringExtra(EXTRA_FOR_GAME_ID)
        }

        val name = intent.getStringExtra(EXTRA_FOR_GAME_NAME)
        val uri = intent.getStringExtra(EXTRA_FOR_GAME_COVER)

        title = name
        Picasso.get().load(uri).into(imageView, object : Callback {
            override fun onError(e: Exception?) {
                supportStartPostponedEnterTransition()
            }

            override fun onSuccess() {
                supportStartPostponedEnterTransition()
            }
        })

    }
}
