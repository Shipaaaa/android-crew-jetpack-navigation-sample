package ru.shipa.navigation.sample.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.transition.MaterialSharedAxis
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentHomeBinding
import ru.shipa.navigation.sample.extension.outcomeTransitionSharedAxis
import ru.shipa.navigation.sample.ui.base.fragment.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewBinding: FragmentHomeBinding by viewBinding()

    private val viewModel: HomeViewModel by viewModels()

    override fun getMessagesContainer() = R.id.root_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        outcomeTransitionSharedAxis(MaterialSharedAxis.X)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.textState, ::handleState)
        observe(viewModel.events, ::handleEvents)

        initViews()
    }

    private fun handleState(state: HomeViewState) {
        viewBinding.textHome.text = state.text
    }

    private fun initViews() {
        viewBinding.counterButton.setOnClickListener { viewModel.onCounterButtonClick() }
        viewBinding.rootCounterButton.setOnClickListener { viewModel.onRootCounterButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
