package com.example.postapp.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.PostApp
import com.example.postapp.R
import com.example.postapp.databinding.FragmentMainBinding
import com.example.postapp.model.canon.Post
import com.example.postapp.utils.ViewState
import com.example.postapp.utils.gone
import com.example.postapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Qualifier


@AndroidEntryPoint
class MainFragment : Fragment(), MainAdapter.OnItemClicked{

    private val mainViewModel: MainViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupReloadButton() {
        binding.errorView.reloadButton.setOnClickListener {
            mainViewModel.loadData()
        }
    }

    private fun setupObservers() {
        observeState()
    }

    private fun observeState() {
        mainViewModel.viewState.observe(viewLifecycleOwner, Observer {
            updateUI(it)
        })
    }

    private fun setupUI() {
        setupReloadButton()
    }

    private fun setUpRecyclerView(postList: List<Post>) {
        val mainAdapter = MainAdapter(postList.toMutableList(), this)
        binding.mainRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }

    private fun updateUI(viewState: ViewState<List<Post>>) {
        when (viewState) {
            ViewState.Error -> setErrorView()
            ViewState.Loading -> setLoadingView()
            is ViewState.Content -> {
                setUpRecyclerView(viewState.data)
                setSuccessView()
            }
        }
    }

    private fun setErrorView() {
        binding.apply {
            mainRecycler.gone()
            progressBar.gone()
            errorView.root.visible()
        }
    }

    private fun setLoadingView() {
        binding.apply {
            errorView.root.gone()
            mainRecycler.gone()
            progressBar.visible()
        }
    }

    private fun setSuccessView() {
        binding.apply {
            progressBar.gone()
            errorView.root.gone()
            mainRecycler.visible()
        }
    }

    override fun itemClicked(post: Post) {
        navigateToDetailFragment(post.id)
    }

    private fun navigateToDetailFragment(postId: Int) {
        val bundle = bundleOf("postId" to postId)
        NavHostFragment.findNavController(this).navigate(R.id.action_MainFragment_to_DetailFragment, bundle)
    }

}