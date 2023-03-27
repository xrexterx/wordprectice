package com.xrexter.wordprectice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlin.concurrent.thread

class FirstFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.first_fragment, container, false)
		val btnAdd = view.findViewById<Button>(R.id.btn_add_word)


		btnAdd.setOnClickListener {
			Log.d("Word Add Button", "clicked")
			thread {
				val userWordDatabase = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "db").build()
				val userDao = userWordDatabase.userWordInterface()
				val idx: Int = userDao.getIndex() + 1
				Log.d("Last idx", idx.toString())
				val eng = view.findViewById<EditText>(R.id.et_add_word_english)
				val kor = view.findViewById<EditText>(R.id.et_add_word_korean)
				userWordDatabase.userWordInterface().insert(
					UserWords(idx, eng.text.toString(), kor.text.toString(), 0, 0)
				)
				val idxCheck: Int = userDao.getIndex()

				if (idxCheck == idx) {
					eng.text = null
					kor.text = null
					val handler = Handler(Looper.getMainLooper())
					handler.postDelayed(Runnable { Toast.makeText(activity, "단어 등록 완료", Toast.LENGTH_SHORT).show() }, 0)
					//Toast.makeText(activity, "단어 등록 완료", Toast.LENGTH_SHORT).show()
				} else {
					Log.d("Insert result", "fail")
				}

			}
		}

		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.d("Data Setup", "Yes")
	}
}