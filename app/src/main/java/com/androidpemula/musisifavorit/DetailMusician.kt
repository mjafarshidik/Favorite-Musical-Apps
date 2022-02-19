package com.androidpemula.musisifavorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMusician : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_musician)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Musisi"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val tvSetOrigin: TextView = findViewById(R.id.tv_item_origin)
        val tvSetGenre: TextView = findViewById(R.id.tv_item_genre)
        val tvSetActive: TextView = findViewById(R.id.tv_item_active)
        val tvSetMember: TextView = findViewById(R.id.tv_item_member)
        val tvSetAlbum: TextView = findViewById(R.id.tv_item_album)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tOrigin  = intent.getStringExtra(EXTRA_ORIGIN)
        val tGenre  = intent.getStringExtra(EXTRA_GENRE)
        val tActive  = intent.getStringExtra(EXTRA_ACTIVE)
        val tMember  = intent.getStringExtra(EXTRA_MEMBER)
        val tAlbum  = intent.getStringExtra(EXTRA_ALBUM)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetOrigin.text = tOrigin
        tvSetGenre.text = tGenre
        tvSetActive.text = tActive
        tvSetMember.text = tMember
        tvSetAlbum.text = tAlbum
        tvSetDetail.text = tDetail
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ORIGIN = "extra_origin"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_ACTIVE = "extra_active"
        const val EXTRA_MEMBER = "extra_member"
        const val EXTRA_ALBUM = "extra_album"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}