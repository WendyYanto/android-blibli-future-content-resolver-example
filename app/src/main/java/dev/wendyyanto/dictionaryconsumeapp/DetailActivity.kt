package dev.wendyyanto.dictionaryconsumeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.wendyyanto.dictionaryconsumeapp.databinding.ActivityDetailBinding
import dev.wendyyanto.dictionaryconsumeapp.utils.ContentResolverUtil

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

    private fun getIndex(): Int {
        return intent?.getIntExtra("INDEX", 0) ?: 0
    }

    private fun loadData() {
        val dictionary = ContentResolverUtil.getDictionaryByIndex(contentResolver, getIndex())
        title = dictionary?.title.orEmpty()
        description = dictionary?.description.orEmpty()
    }

    private fun setupUi() {
        with(viewBinding) {
            tvInfo.text = "Showing result of index: ${getIndex()}"
            tvTitle.text = "Title : $title"
            tvDescription.text = "Description: $description"
        }
    }
}