package com.example.postapp.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.PostApp
import com.example.postapp.databinding.FragmentDetailBinding
import com.example.postapp.model.canon.PostDetail
import com.example.postapp.utils.ViewState
import com.example.postapp.utils.gone
import com.example.postapp.utils.visible
import javax.inject.Inject


class DetailFragment : Fragment() {

    @Inject
    lateinit var detailViewModel: DetailViewModel

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    var postId: Int? = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val bundle = arguments
        postId = bundle?.getInt("postId")
        postId?.let { detailViewModel.initialize(it) }
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

    init {
        PostApp.daggerAppComponent().inject(this)
    }

    private fun setupReloadButton() {
        postId?.let {
            binding.detailErrorView.reloadButton.setOnClickListener {
                detailViewModel.initialize(postId!!)
            }
        }
    }

    private fun setupObservers() {
        observeState()
    }

    private fun observeState() {
        detailViewModel.viewState.observe(viewLifecycleOwner, Observer {
            updateUI(it)
        })
    }

    private fun setupUI() {
        setupReloadButton()
    }

    private fun setupView(postDetail: PostDetail) {
        binding.apply {
            titleTextView.text = postDetail.title
            userTextView.text = postDetail.user
            bodyTextView.text = postDetail.body
            commentsRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = CommentAdapter(postDetail.commentList?.toMutableList())
            }
        }
    }

    private fun updateUI(it: ViewState<PostDetail>?) {
        when (it) {
            ViewState.Error -> setErrorView()
            ViewState.Loading -> setLoadingView()
            is ViewState.Content -> {
                setupView(it.data)
                setSuccessView()
            }
        }
    }

    private fun setErrorView() {
        binding.apply {
            detailProgressBar.gone()
            detailContent.gone()
            detailErrorView.root.visible()
        }
    }

    private fun setLoadingView() {
        binding.apply {
            detailErrorView.root.gone()
            detailContent.gone()
            detailProgressBar.visible()
        }
    }

    private fun setSuccessView() {
        binding.apply {
            detailProgressBar.gone()
            detailErrorView.root.gone()
            detailContent.visible()
        }
    }
}