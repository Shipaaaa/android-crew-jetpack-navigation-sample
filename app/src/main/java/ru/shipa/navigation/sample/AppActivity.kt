package ru.shipa.navigation.sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.redmadrobot.extensions.lifecycle.Event
import com.redmadrobot.extensions.lifecycle.observe
import ru.shipa.navigation.sample.extension.navigateSafe
import ru.shipa.navigation.sample.ui.base.activity.BaseActivity
import ru.shipa.navigation.sample.ui.base.viewmodel.event.NavigationEvent

class AppActivity : BaseActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        observe(viewModel.startScreen, ::handleStartScreen)
        observe(viewModel.events, ::handleEvents)
    }

    private fun handleStartScreen(startScreen: StartScreenViewState) {
        val navController = Navigation.findNavController(this, R.id.activity_app_screens_container)

        val mainGraph = navController.navInflater.inflate(R.navigation.root_nav_graph).apply {
            startDestination = startScreen.resId
        }

        navController.setGraph(mainGraph, startScreen.args)
    }

    @Suppress("ComplexMethod")
    private fun handleEvents(event: Event) {
        when (event) {
            is NavigationEvent -> {
                when (event) {
                    is NavigationEvent.ToDirection -> getNavController().navigateSafe(event.direction)
                    is NavigationEvent.ToRes -> getNavController().navigateSafe(event.resId, event.args)
                    is NavigationEvent.Up -> getNavController().navigateUp()
                    is NavigationEvent.Back -> if (!getNavController().popBackStack()) finish()
                    is NavigationEvent.BackTo -> getNavController().popBackStack(event.destinationId, event.inclusive)
                }
            }
        }
    }

    private fun getNavController() = findNavController(R.id.activity_app_screens_container)
}
