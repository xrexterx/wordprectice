package com.xrexter.wordprectice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val context: Context) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {
	var datas = mutableListOf<WordsData>()
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
		val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent,false)
		return ViewHolder(view)
	}

	override fun getItemCount(): Int = datas.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(datas[position])
	}

	inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		private val txtEng: TextView = itemView.findViewById(R.id.tv_rv_eng)
		private val txtKor: TextView = itemView.findViewById(R.id.tv_rv_kor)
		private val txtCorrectCount: TextView = itemView.findViewById(R.id.tv_rv_correct_count)
		private val txtWrongCount: TextView = itemView.findViewById(R.id.tv_rv_wrong_count)

		fun bind(item: WordsData) {
			txtEng.text = item.eng
			txtKor.text = item.kor
			txtCorrectCount.text = item.correctCounts.toString()
			txtWrongCount.text = item.wrongCounts.toString()
		}
	}
}