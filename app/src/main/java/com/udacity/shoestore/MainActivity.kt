package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

//    Configuration options for NavigationUI methods that interact with implementations of the app bar
//    pattern such as androidx.appcompat.widget.Toolbar, com.google.android.material.appbar.CollapsingToolbarLayout,
//    and androidx.appcompat.app.ActionBar
    private lateinit var appBarConfiguration: AppBarConfiguration

//    onCreate is where you initialize your activity. Most importantly, here you will usually call
//    setContentView(int) with a layout resource defining your UI, and using findViewById(int) to
//    retrieve the widgets in that UI that you need to interact with programmatically
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the activity content to an explicit view. This view is placed directly into the
        // activity's view hierarchy. It an itself be a complex view hierarchy.
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment

        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(findViewById(R.id.topAppBar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Sets up a Toolbar for use with a NavController. By calling this method, the title
        // in the Toolbar automatically be updated when the destination changes
        // The start destination of your navigation graph is considered the only top level
        // destination. On the start destination of your navigation graph, the Toolbar
        findViewById<Toolbar>(R.id.topAppBar).setupWithNavController(navController, appBarConfiguration)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //    This method is called whenever the user chooses to navigate Up within your application's
    //    activity hierarchy from the action bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) ||
        return super.onSupportNavigateUp()
    }
}
