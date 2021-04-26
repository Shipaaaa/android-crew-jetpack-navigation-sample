package ru.shipa.navigation.sample.ui.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentNotificationsBinding
import ru.shipa.navigation.sample.ui.base.BaseFragment

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val viewBinding: FragmentNotificationsBinding by viewBinding()

    private val viewModel: NotificationsViewModel by viewModels()

    override val messagesContainer = R.id.root_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.text, ::handleState)
        observe(viewModel.events, ::handleEvent)

        initViews()
    }

    private fun handleState(text: String) {
        viewBinding.textNotifications.text = text
    }

    private fun initViews() {
        viewBinding.counterButton.setOnClickListener { viewModel.onCounterButtonClick() }

        viewBinding.successButton.setOnClickListener { viewModel.onSuccessButtonClick() }
        viewBinding.errorButton.setOnClickListener { viewModel.onErrorButtonClick() }
    }
}
