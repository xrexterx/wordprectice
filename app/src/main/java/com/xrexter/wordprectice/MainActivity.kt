package com.xrexter.wordprectice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import com.google.android.material.tabs.TabLayoutMediator
import com.xrexter.wordprectice.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
//	lateinit var wordsAdapter: WordsAdapter
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		setupViewPager()
		setupTabLayout()


//		val rvWords = findViewById<RecyclerView>(R.id.rv_words)
//		wordsAdapter = WordsAdapter(this)
//		rvWords.adapter = wordsAdapter
//
//		val btnAdd: Button = findViewById(R.id.btn_add_word)
//		val btnAddWordConfirm: Button = findViewById(R.id.btn_word_add_confirm)
//		val btnShowWords: Button = findViewById(R.id.btn_word_test)
//
//		val layoutAddWord = findViewById<LinearLayout>(R.id.layout_word_add)
//
//		btnShowWords.setOnClickListener {
//
//			thread {
//				val userWordsDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "db").build()
//				val words = userWordsDatabase.userWordInterface().getAll()
//				runOnUiThread {
//					for (item in words) {
//						wordsAdapter.datas.add(WordsData(item.english.toString(), item.korean.toString(), item.correct_count, item.wrong_count))
//						wordsAdapter.notifyItemInserted(item.idx)
//					}
//				}
//			}
//
//		}
//
//		btnAdd.setOnClickListener {
//			layoutAddWord.visibility = View.VISIBLE
//		}
//
//		btnAddWordConfirm.setOnClickListener {
//			thread{
//				insertWord()
//			}
//		}
//	}
//
//	private fun insertWord() {
//		var eng: String? = null
//		var kor: String? = null
//
//		runOnUiThread {
//			eng = findViewById<EditText>(R.id.add_word_eng).text.toString()
//			kor = findViewById<EditText>(R.id.add_word_kor).text.toString()
//		}
//
//		val userWordsDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "db").build()
//		val idx = userWordsDatabase.userWordInterface().getIndex() + 1
//
//		thread {
//			userWordsDatabase.userWordInterface().insert(
//				UserWords(
//					idx,
//					eng,
//					kor,
//					0,
//					0
//				)
//			)
//		}
	}
	private fun setupTabLayout() {
		TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
			tab.text = "Tab" + (position + 1)
		}.attach()
	}

	private fun setupViewPager() {
		val adapter = ViewPagerAdapter(this, 2)
		binding.viewPager.adapter = adapter
	}
}

