package com.example.chuckle_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.chuckle_app.ui.main.ListViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

lateinit var listViewModelFactory: ListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init listViewModelFactory
        val appComponent = (application as ChuckleApplication).applicationComponent
        val getRandomJokeUseCase = appComponent.getGetRandomJokeUseCase()
        listViewModelFactory = ListViewModelFactory(getRandomJokeUseCase)

        //init navigation controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupWithNavController(navigation_drawer, navController)

    }
}