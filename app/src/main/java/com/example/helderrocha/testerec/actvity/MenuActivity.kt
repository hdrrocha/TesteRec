package com.example.helderrocha.testerec.actvity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.helderrocha.testerec.R
import com.example.helderrocha.testerec.fragment.MainFragment
import com.example.helderrocha.testerec.fragment.MoviesListFragment
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.app_bar_menu.*

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

        //Carrega tela principal
        val mainFragment = MainFragment()
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frameContainer, mainFragment)
        fragment.commit()

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { sentEmail() }


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
        menuInflater.inflate(R.menu.menu, menu)
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
        val id = item.itemId

        if (id == R.id.nav_main) {
            sentEmail()
            val mainFragment = MainFragment()
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.frameContainer, mainFragment)
            fragment.commit()

        } else if (id == R.id.nav_moviews_list) {

            val moviesListFragmentt = MoviesListFragment()
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.frameContainer, moviesListFragmentt)
            fragment.commit()

        }else if (id == R.id.nav_sobre) {

            startActivity(Intent(this, AboutActivity::class.java))

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun sentEmail() {

        val email = Intent(Intent.ACTION_SEND)
        email.putExtra(Intent.EXTRA_EMAIL, arrayOf("email@gmail.com"))
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App")
        email.putExtra(Intent.EXTRA_TEXT, "Hi I'm cool")

        //configurar apps para e-mail
        email.type = "message/rfc822"
        //email.setType("application/pdf");
        //email.setType("image/png");

        startActivity(Intent.createChooser(email, "Escolha o App de e-mail:"))


    }
}
