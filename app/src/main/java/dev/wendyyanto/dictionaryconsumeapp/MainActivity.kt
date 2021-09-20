package dev.wendyyanto.dictionaryconsumeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.wendyyanto.dictionaryconsumeapp.adapter.DictionaryAdapter
import dev.wendyyanto.dictionaryconsumeapp.databinding.ActivityMainBinding
import dev.wendyyanto.dictionaryconsumeapp.model.DictionaryUiModel

class MainActivity : AppCompatActivity() {


    private lateinit var viewBinding: ActivityMainBinding

    private lateinit var dictionaryAdapter: DictionaryAdapter

    private val dictionaries: MutableList<DictionaryUiModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        loadDictionaries()

        setupAdapters()
    }

    private fun loadDictionaries() {
        // ToDo: Implement load dictionaries using content provider
    }

    private fun setupAdapters() {
        with(viewBinding.rvDictionaries) {
            dictionaryAdapter = DictionaryAdapter(dictionaries)
            adapter = dictionaryAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}