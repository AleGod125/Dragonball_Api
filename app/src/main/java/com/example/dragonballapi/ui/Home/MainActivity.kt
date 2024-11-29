package com.example.dragonballapi.ui.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dragonballapi.databinding.ActivityMainBinding
import com.example.dragonballapi.domain.usecase.GetCharaters
import com.example.dragonballapi.ui.Home.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = GetCharaters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la vista de carga
        showLoading(true)
        loadCharacters(1, 78)
    }

    private fun loadCharacters(page: Int, limit: Int) {
        lifecycleScope.launch {
            try {
                val response = repository.getCharacters(page, limit)
                Log.d("characters", "Personajes obtenidos: ${response.items}")

                binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.recyclerview.adapter = CharacterAdapter(response.items)
                binding.charcters.text = "CHARACTERS: ${response.items.size}"

                showLoading(false)
            } catch (e: Exception) {
                Log.e("characters", "Error al obtener los personajes: ${e.message}", e)

                // Ocultar la vista de carga incluso en caso de error
                showLoading(false)
            }
        }
    }

    // Método para mostrar u ocultar la vista de carga
    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.recyclerview.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}
