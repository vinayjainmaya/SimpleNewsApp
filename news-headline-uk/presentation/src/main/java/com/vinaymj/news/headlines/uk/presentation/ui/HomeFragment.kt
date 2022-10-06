package com.vinaymj.news.headlines.uk.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.vinaymj.news.headlines.uk.presentation.databinding.FragmentHomeBinding
import com.vinaymj.simplenewsapp.core.api.Response
import com.vinaymj.simplenewsapp.core.utils.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var homeAdapter: HomeAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getTopHeadlines("GB")
        setObserver()
    }

    private fun setObserver() {
        homeViewModel.news.observe(viewLifecycleOwner) { event ->
            event?.getContentIfNotHandled()?.let { response ->
                when (response) {
                    is Response.Success -> {
                        binding.progressCircular.isVisible = false
                        homeAdapter = HomeAdapter(this)
                        homeAdapter.setItem(response.data?.articles)
                        binding.ukNewsList.apply {
                            adapter = homeAdapter
                        }
                        homeAdapter.notifyDataSetChanged()
                    }
                    is Response.Loading -> {
                        binding.progressCircular.isVisible = true
                    }
                    else -> {
                        binding.progressCircular.isVisible = false

                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(s: String) {

    }
}