package com.xrexter.wordprectice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.first_fragment, container, false)
		val btnAdd = view.findViewById<Button>(R.id.btn_add_word)

		btnAdd.setOnClickListener {
			Log.d("ADD BUTTON", "clicked")
		}

		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.d("Data Setup", "Yes")
	}
}