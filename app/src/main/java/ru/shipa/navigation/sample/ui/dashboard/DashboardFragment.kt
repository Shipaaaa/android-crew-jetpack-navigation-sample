package ru.shipa.navigation.sample.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentDashboardBinding
import ru.shipa.navigation.sample.ui.base.fragment.BaseFragment

class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val viewBinding: FragmentDashboardBinding by viewBinding()

    private val viewModel: DashboardViewModel by viewModels()

    override fun getMessagesContainer() = R.id.root_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.textState, ::handleState)
        observe(viewModel.events, ::handleEvents)

        initViews()
    }

    private fun handleState(state: DashboardViewState) {
        viewBinding.textDashboard.text = state.text
    }

    private fun initViews() {
        viewBinding.counterButton.setOnClickListener { viewModel.onCounterButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
