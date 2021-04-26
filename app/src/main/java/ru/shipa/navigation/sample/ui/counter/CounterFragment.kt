package ru.shipa.navigation.sample.ui.counter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentCounterBinding
import ru.shipa.navigation.sample.ui.base.BaseFragment

class CounterFragment : BaseFragment(R.layout.fragment_counter) {

    private val args: CounterFragmentArgs by navArgs()

    private val viewBinding: FragmentCounterBinding by viewBinding()

    private val viewModel: CountViewModel by viewModels()

    override val messagesContainer = R.id.root_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.text, ::handleState)
        observe(viewModel.events, ::handleEvent)

        viewModel.setCount(args.counter)

        initView()
    }

    private fun handleState(count: Int) {
        viewBinding.counterText.text = getString(R.string.counter_text, count)
    }

    private fun initView() {
        viewBinding.countButton.setOnClickListener { viewModel.onCountButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
