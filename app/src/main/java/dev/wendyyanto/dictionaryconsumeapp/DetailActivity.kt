package dev.wendyyanto.dictionaryconsumeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.wendyyanto.dictionaryconsumeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDetailBinding

    private var title: String = ""

    private var description: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        loadData()
        setupUi()
    }

    private fun loadData() {
        // ToDo: load dictionary data by content resolver
    }

    private fun setupUi() {
        val index = intent?.getIntExtra("INDEX", 0) ?: 0

        with(viewBinding) {
            tvInfo.text = "Showing result of index: $index"
            tvTitle.text = "Title : $title"
            tvDescription.text = "Description: $description"
        }
    }
}