package com.example.mvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvm.R
import com.example.mvvm.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    private  val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add.setOnClickListener {
            viewModel.onIncrementClick()

        }
        btn_minus.setOnClickListener {
            viewModel.onDecrementClick()
        }
    }
}