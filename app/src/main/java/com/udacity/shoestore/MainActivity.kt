package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        findViewById<Toolbar>(R.id.topAppBar)
            .setupWithNavController(navController, appBarConfiguration)

//        THIS CONFLICTS WITH onSupportNavigateUp() WILL NOT ALLOW APP TO NAVIGATE UP WHEN USED.
//        topAppBar.setNavigationOnClickListener {
//            // Handle navigation icon press
//        }

        // Set a custom listener for invocation of this menu item. In most situations, it is more
        // efficient and easier to use
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout -> {
                    // Logout icon press function
                    true
                }
                R.id.favorite -> {
                    // Handle favorite icon press
                    true
                }
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }
    }
//    This method is called whenever the user chooses to navigate Up within your application's
//    activity hierarchy from the action bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) ||
        return super.onSupportNavigateUp()
    }

    // This hook is called whenever an item in your options menu is selected. The default
    // implementation simply returns false to have the normal processing happen (calling the
    // item's Runnable or sending a message to its Handler as appropriate). You can use this
    // method for any items for which you would like to do processing without those other
    // facilities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
