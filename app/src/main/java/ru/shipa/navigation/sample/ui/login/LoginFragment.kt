package ru.shipa.navigation.sample.ui.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentLoginBinding
import ru.shipa.navigation.sample.ui.base.fragment.BaseFragment

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewBinding: FragmentLoginBinding by viewBinding()

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.login, ::handleLogin)
        observe(viewModel.password, ::handlePassword)
        observe(viewModel.buttonEnabled, ::handleButton)
        observe(viewModel.events, ::handleEvents)

        initViews()
    }

    private fun initViews() {
        with(viewBinding) {
            login.doOnTextChanged { _, _, _, _ -> onCredentialsChanged() }
            password.doOnTextChanged { _, _, _, _ -> onCredentialsChanged() }

            buttonToList.setOnClickListener { onToListButtonClick() }
        }
    }

    private fun onCredentialsChanged() {
        viewModel.onCredentialsChanged(
            viewBinding.login.text.toString(),
            viewBinding.password.text.toString()
        )
    }

    private fun onToListButtonClick() {
        viewModel.onEnterButtonClick(
            viewBinding.login.text.toString(),
            viewBinding.password.text.toString()
        )
    }

    private fun handleLogin(login: String) {
        viewBinding.login.apply {
            if (text.toString() != login) setText(login)
        }
    }

    private fun handlePassword(password: String) {
        viewBinding.password.apply {
            if (text.toString() != password) setText(password)
        }
    }

    private fun handleButton(buttonEnabled: Boolean) {
        viewBinding.buttonToList.isEnabled = buttonEnabled
    }
}
