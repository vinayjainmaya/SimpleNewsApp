package com.vinaymj.news.headline.presentation.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vinaymj.news.headline.presentation.databinding.FragmentIndiaBinding
import com.vinaymj.simplenewsapp.core.api.Response
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IndianNewsFragment : Fragment(), com.vinaymj.simplenewsapp.core.utils.OnItemClickListener {

    private var _binding: FragmentIndiaBinding? = null
    private val indianNewsViewModel: IndianNewsViewModel by activityViewModels()
    private lateinit var indiaNewsAdapter: IndiaNewsAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIndiaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indianNewsViewModel.getTopHeadlines("in")
        setObserver()
    }

    private fun setObserver() {
        indianNewsViewModel.news.observe(viewLifecycleOwner) { event ->
            event?.getContentIfNotHandled()?.let { response ->
                when (response) {
                    is Response.Success -> {
                        binding.progressCircular.isVisible = false
                        indiaNewsAdapter = IndiaNewsAdapter(this)
                        indiaNewsAdapter.setItem(response.data?.articles)
                        binding.inNewsList.apply {
                            adapter = indiaNewsAdapter
                        }
                        indiaNewsAdapter.notifyDataSetChanged()
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