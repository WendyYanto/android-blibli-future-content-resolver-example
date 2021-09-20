package dev.wendyyanto.dictionaryconsumeapp.utils

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import dev.wendyyanto.dictionaryconsumeapp.constants.DictionaryUri
import dev.wendyyanto.dictionaryconsumeapp.model.DictionaryUiModel

object ContentResolverUtil {

    fun getDictionaries(contentResolver: ContentResolver): List<DictionaryUiModel> {
        val dictionaries = mutableListOf<DictionaryUiModel>()

        val cursor = contentResolver.query(
            Uri.parse(DictionaryUri.CONTENT),
            arrayOf("title", "description"),
            null,
            null,
            null
        )

        traverseCursor(cursor) { title, description ->
            dictionaries.add(DictionaryUiModel(title = title, description = description))
        }

        return dictionaries
    }


    private fun traverseCursor(
        cursor: Cursor?,
        onDataLoaded: (title: String, description: String) -> Unit
    ) {
        val titleIndex = cursor?.getColumnIndex("title")
        val descriptionIndex = cursor?.getColumnIndex("description")

        cursor?.moveToFirst()

        do {
            var title = ""
            var description = ""

            titleIndex?.let { safeTitleIndex ->
                title = cursor.getString(safeTitleIndex)
            }

            descriptionIndex?.let { safeDescriptionIndex ->
                description = cursor.getString(safeDescriptionIndex)
            }

            onDataLoaded(title, description)
        } while (cursor?.moveToNext() == true)

        cursor?.close()
    }

    fun getDictionaryByIndex(contentResolver: ContentResolver, index: Int): DictionaryUiModel? {
        var dictionary: DictionaryUiModel? = null

        val cursor = contentResolver.query(
            Uri.parse(DictionaryUri.CONTENT + "/" + index),
            arrayOf("title", "description"),
            null,
            null,
            null
        )

        traverseCursor(cursor) { title, description ->
            dictionary = DictionaryUiModel(title = title, description = description)
        }

        return dictionary
    }
}