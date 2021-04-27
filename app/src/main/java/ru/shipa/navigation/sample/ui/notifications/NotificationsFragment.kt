package ru.shipa.navigation.sample.ui.notifications

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.transition.MaterialSharedAxis
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentNotificationsBinding
import ru.shipa.navigation.sample.extension.addOnBackPressedCallback
import ru.shipa.navigation.sample.extension.outcomeTransitionSharedAxis
import ru.shipa.navigation.sample.ui.base.fragment.BaseFragment

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val viewBinding: FragmentNotificationsBinding by viewBinding()

    private val viewModel: NotificationsViewModel by viewModels()

    override fun getMessagesContainer() = R.id.root_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        outcomeTransitionSharedAxis(MaterialSharedAxis.X)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        addOnBackPressedCallback { viewModel.onExitButtonClick() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.textState, ::handleState)
        observe(viewModel.events, ::handleEvents)

        initViews()
    }

    private fun handleState(state: NotificationsViewState) {
        viewBinding.textNotifications.text = state.text
    }

    private fun initViews() {
        viewBinding.counterButton.setOnClickListener { viewModel.onCounterButtonClick() }
        viewBinding.exitButton.setOnClickListener { viewModel.onExitButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
