package ru.shipa.navigation.sample

import android.os.Bundle
import ru.shipa.navigation.sample.ui.base.BaseActivity

class AppActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }
}
