package dev.wendyyanto.dictionaryconsumeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wendyyanto.dictionaryconsumeapp.databinding.ItemDictionaryBinding
import dev.wendyyanto.dictionaryconsumeapp.model.DictionaryUiModel

class DictionaryAdapter(
    private val items: List<DictionaryUiModel>,
    private inline val onClickListener: (index: Int) -> Unit
) :
    RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        val viewBinding = ItemDictionaryBinding.inflate(LayoutInflater.from(parent.context))
        return DictionaryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class DictionaryViewHolder(private val viewBinding: ItemDictionaryBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(dictionaryUiModel: DictionaryUiModel) {
            with(viewBinding) {
                tvTitle.text = dictionaryUiModel.title
                tvTitle.setOnClickListener {
                    onClickListener(adapterPosition)
                }

                tvDescription.text = dictionaryUiModel.description
            }
        }
    }
}