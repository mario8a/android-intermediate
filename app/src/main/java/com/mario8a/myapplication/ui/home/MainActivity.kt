package com.mario8a.myapplication.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mario8a.myapplication.R
import com.mario8a.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// Siempre hay que preparar las clases para que puedan ser inyectadas con la inyeccionde dependencias, se hace en todos los fragment
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicnado el bonding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        initNavigation()
    }

    private fun initNavigation() {
        val navhost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navhost.navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}