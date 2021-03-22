package swu.cs.foodrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import swu.cs.foodrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerFragment)
                as NavHostFragment
        navController = navHostFragment.navController

        binding?.bottomNavigationView?.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.recipesFragment,
                R.id.favoriteFragment,
                R.id.jokeFragment)
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}