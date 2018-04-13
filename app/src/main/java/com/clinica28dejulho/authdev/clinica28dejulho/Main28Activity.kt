package com.clinica28dejulho.authdev.clinica28dejulho

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main28.*
import kotlinx.android.synthetic.main.app_bar_main28.*
import kotlinx.android.synthetic.main.content_main28.*

class Main28Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var rotateForward : Animation
    private lateinit var rotateBackward : Animation
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private var isOpen = false

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main28)
        setSupportActionBar(toolbar)

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)
        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward)
        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward)

        fab.setOnClickListener {
            AnimFab()
        }

        fab1.setOnClickListener{
            val uriWhats = Uri.parse("https://api.whatsapp.com/send?phone=5573991522828")
            startActivity(Intent(Intent.ACTION_VIEW,uriWhats))
        }

        fab2.setOnClickListener{
            val uriMessenger = Uri.parse("https://www.facebook.com/messages/t/100013629798692")
            startActivity(Intent(Intent.ACTION_VIEW,uriMessenger))
        }

        fab3.setOnClickListener {
            val uris = Uri.parse("tel:"+"7332152828")
            startActivity(Intent(Intent.ACTION_DIAL,uris))
        }

        button_consultas.setOnClickListener {
            val intent  =  Intent(this,EspecialidadesActivity::class.java)
            startActivity(intent)
        }
        button_exames.setOnClickListener{
            startActivity(Intent(this,ExamesActivity::class.java))
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main28, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_atendimento -> {
                val intent  =  Intent(this,EspecialidadesActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_exames_complementares -> {
                startActivity(Intent(this,ExamesActivity::class.java))
            }
            R.id.nav_sala_vacinas -> {
                startActivity(Intent(this,MapsActivity::class.java))

            }
            R.id.nav_exames_laboratoriais -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun AnimFab()
    {
        if (isOpen) {

            fab.startAnimation(rotateBackward)
            fab1.startAnimation(fabClose)
            fab2.startAnimation(fabClose)
            fab3.startAnimation(fabClose)
            fab1.isClickable = false
            fab2.isClickable = false
            fab3.isClickable = false
            isOpen = false

        }else
        {
            fab.startAnimation(rotateForward)
            fab1.startAnimation(fabOpen)
            fab2.startAnimation(fabOpen)
            fab3.startAnimation(fabOpen)
            fab1.isClickable = true
            fab2.isClickable = true
            fab3.isClickable = true
            isOpen = true
        }
    }
}
