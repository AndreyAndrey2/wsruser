package com.example.wsruserfood.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wsruserfood.R
import com.example.wsruserfood.databinding.ActivityMainBinding
import ru.example.wsrfood.extensions.gone
import ru.example.wsrfood.extensions.visible

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }

        binding.bottomNavigationView.setupWithNavController(navController)

        // Отключаем обновление фрагмента при выборе той же вкладки
        //binding.bottomNavigationView.setOnNavigationItemReselectedListener {  }
        }
    // Функция для вызова из фрагментов
    fun setNavigationBarVisible(isVisible: Boolean) {
        if (isVisible) {
            binding.bottomNavigationView.visible()
        } else {
            binding.bottomNavigationView.gone()
        }
    }
}