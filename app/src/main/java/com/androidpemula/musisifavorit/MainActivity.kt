package com.androidpemula.musisifavorit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusician: RecyclerView
    private var list: ArrayList<Musician> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title= "Musisi Favorit"

        rvMusician = findViewById(R.id.rv_musicians)
        rvMusician.setHasFixedSize(true)

        list.addAll(MusiciansData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMusician.layoutManager = LinearLayoutManager(this)
        val listMusicianAdapter = ListMusicianAdapter(list)
        rvMusician.adapter = listMusicianAdapter

        listMusicianAdapter.setOnItemClickCallback(object : ListMusicianAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Musician) {
                showSelectedMusician(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedMusician(musician: Musician) {
        Toast.makeText(this, "Kamu memilih " + musician.name, Toast.LENGTH_SHORT).show()
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentAbout)
            }
        }
    }
}