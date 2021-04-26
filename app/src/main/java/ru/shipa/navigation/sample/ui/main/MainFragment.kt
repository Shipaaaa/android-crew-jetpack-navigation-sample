package ru.shipa.navigation.sample.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.setupWithNavController
import com.redmadrobot.extensions.lifecycle.observe
import com.redmadrobot.extensions.viewbinding.viewBinding
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.databinding.FragmentMainBinding
import ru.shipa.navigation.sample.extension.setupWithNavController
import ru.shipa.navigation.sample.ui.base.BaseFragment

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val viewBinding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Else, need to wait for onRestoreInstanceState
        if (savedInstanceState == null) setupBottomNavigationBar()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navControllerLiveData = viewBinding.bottomNavigationView.setupWithNavController(
            fragmentManager = childFragmentManager,
            containerId = R.id.fragment_main_screens_container,
            intent = requireActivity().intent,
            navGraphIds = listOf(
                R.navigation.menu_home_nav_graph,
                R.navigation.menu_dashboard_nav_graph,
                R.navigation.menu_notifications_nav_graph
            )
        )

        observe(navControllerLiveData) { navController ->
            viewBinding.toolbar.setupWithNavController(navController)
        }
    }
}
