package com.example.dbfordodo.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener


class MainActivity : AppCompatActivity() {

    //Binding this layout
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToogle : ActionBarDrawerToggle

    lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        drawer = binding.root
        setContentView(binding.root)

        val vm: ViewModelProvider.Factory

        //Navigation view getting from layout
        val bottomNavView = binding.bottomNavView

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // Getting my Nav Host and setting to it a Nav Controller
        val navFragment =
            supportFragmentManager.findFragmentById(binding.fragmentsContainer.id) as NavHostFragment
        val navController = navFragment.navController

        Log.d("example_tag", "Step 3")
        //Implementing navigation beetween fragments clicking Bottom NavView
        bottomNavView.setupWithNavController(navController)
        bottomNavView.itemIconTintList = null

        drawerToogle = ActionBarDrawerToggle(this,binding.root,R.string.open,R.string.close)
        binding.root.addDrawerListener(drawerToogle)
        drawerToogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
//            binding.bottomNavView.visibility = when (destination.id) {
//                R.id.splashFragment, R.id.storesFragment, R.id.showFragment2 -> ViewGroup.GONE
//                else -> VISIBLE
//            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToogle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}