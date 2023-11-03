package com.example.okhttpexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.okhttpexample.data.fetchUsers
import com.example.okhttpexample.databinding.FragmentHomeBinding
import com.example.okhttpexample.utils.hideView
import com.example.okhttpexample.utils.visible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()

    }

    private fun fetchData() = binding.apply{
        lifecycleScope.launch(Dispatchers.Main) {
            progressBar.visible()
            val usersList = withContext(Dispatchers.IO) {
                fetchUsers()
            }
            progressBar.hideView()
            val adapter = UserAdapter(usersList)
            rvMain.adapter = adapter
        }
    }
}