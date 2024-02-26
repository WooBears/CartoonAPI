package com.example.rickapi2ndex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickapi2ndex.adapter.CartoonAdapter
import com.example.rickapi2ndex.data.CartoonApiService
import com.example.rickapi2ndex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity
 : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CartoonAdapter

    @Inject
    lateinit var cartoonApiService: CartoonApiService

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CartoonAdapter()
        binding.rvRecyclerview.adapter = adapter

            CoroutineScope(Dispatchers.IO).launch {

                val hero = cartoonApiService.getAllCartoons()
                val cartoons = hero.results
                runOnUiThread {
                    adapter.addCartoon(cartoons)
                }
            }
    }
}