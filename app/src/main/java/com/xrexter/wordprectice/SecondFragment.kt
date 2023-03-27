package com.xrexter.wordprectice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.xrexter.wordprectice.databinding.SecondFragmentBinding
import kotlin.concurrent.thread

class SecondFragment: Fragment() {
//	private lateinit var binding: SecondFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.second_fragment, container, false)
		val rvWordList = view.findViewById<RecyclerView>(R.id.rv_word_list)
		val wordsListAdapter = WordsAdapter(requireContext())
		rvWordList.adapter = wordsListAdapter

		thread {
			val userWordsDatabase = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "db").build()
			val wordsList = userWordsDatabase.userWordInterface().getAll()

			val handler = Handler(Looper.getMainLooper())
			handler.postDelayed(Runnable {
				wordsListAdapter.datas.add(WordsData("Eng", "Kor", "맞힘", "틀림"))
				for (item in wordsList) {
					wordsListAdapter.datas.add(WordsData(item.english.toString(), item.korean.toString(), item.correct_count.toString(), item.wrong_count.toString()))
					wordsListAdapter.notifyItemInserted(item.idx+1)
				}
			}, 0)
		}

		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.d("View Created", "Yes")
	}
}