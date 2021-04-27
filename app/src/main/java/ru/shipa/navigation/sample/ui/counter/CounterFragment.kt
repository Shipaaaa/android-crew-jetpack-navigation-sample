package ru.shipa.navigation.sample.ui.counter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialSharedAxis
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentCounterBinding
import ru.shipa.navigation.sample.extension.incomeTransitionSharedAxis
import ru.shipa.navigation.sample.ui.base.fragment.BaseFragment

class CounterFragment : BaseFragment(R.layout.fragment_counter) {

    private val args: CounterFragmentArgs by navArgs()

    private val viewBinding: FragmentCounterBinding by viewBinding()

    private val viewModel: CountViewModel by viewModels()

    override fun getMessagesContainer() = R.id.root_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        incomeTransitionSharedAxis(MaterialSharedAxis.X)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.counterState, ::handleState)
        observe(viewModel.events, ::handleEvents)

        viewModel.setCount(args.counter)

        initView()
    }

    private fun handleState(state: CounterViewState) {
        viewBinding.counterText.text = getString(R.string.counter_text, state.counter)
    }

    private fun initView() {
        viewBinding.countButton.setOnClickListener { viewModel.onCountButtonClick() }
        viewBinding.backButton.setOnClickListener { viewModel.onBackButtonClick() }
        viewBinding.mainButton.setOnClickListener { viewModel.onMainButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
