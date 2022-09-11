package com.example.pptapp

import android.os.Bundle
import android.view.*
import android.widget.ImageView

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pptapp.databinding.JoinTournamentPageBinding
import com.example.pptapp.databinding.MainPageBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainPageActivity: AppCompatActivity() {

    private var _binding: MainPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var profileIco : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout
        navigationView = binding.navView
        navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment_content_main_page
        )

        profileIco = navigationView.getHeaderView(0)
        val prof = profileIco.findViewById<ImageView>(R.id.profilebtn)
        prof.setOnClickListener {
            navController.navigate(R.id.profileFragment)
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        appBarConfiguration = AppBarConfiguration(
            setOf(
            R.id.nav_match_history,
            R.id.nav_friends,
            R.id.nav_gallery,
            R.id.nav_join_tournament,
            R.id.nav_create_tournament,
            R.id.profileFragment
        ), drawerLayout)


            setupActionBarWithNavController(navController, drawerLayout)
            navigationView.setupWithNavController(navController)


    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main_page)
        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }
}




//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: MainPageBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = MainPageBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.appBarMain.toolbar)
//
//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_friends, R.id.nav_gallery, R.id.nav_join_tournament
//            ), drawerLayout
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
//}


//lateinit var toggle: ActionBarDrawerToggle
//
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.main_page)
//
//    val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
//    val navView: NavigationView = findViewById(R.id.nav_view)
//
//    toggle = ActionBarDrawerToggle(this, drawerLayout,  R.string.open, R.string.close)
//    drawerLayout.addDrawerListener(toggle)
//    toggle.syncState()
//
//    supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    navView.setNavigationItemSelectedListener {
//        try {
//            when(it.itemId){
//
//                R.id.nav_friends -> {
//                    findNavController(R.id.my_nav_host_fragment).navigate(R.id.action_blankFragment_to_friendsPageActivity)
//                    println("I am working properly! Yay!")
//                }
//                R.id.nav_join_tournament -> {
//                    findNavController(R.id.my_nav_host_fragment).navigate(R.id.action_blankFragment_to_joinTournamentPageActivity)
//                }
//                R.id.nav_create_tournament -> {
//
//                }
//                R.id.nav_match_history -> {
//
//                }
//            }
//        }catch (e:Exception){
//            println(e.message)
//        }
//        true
//    }
//}
//
//override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//    if(toggle.onOptionsItemSelected(item)){
//        return true
//    }
//    return super.onOptionsItemSelected(item)
//}