package com.sinjidragon.turlgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sinjidragon.turlgo.feature.data.login.di.loginRepositoryModule
import com.sinjidragon.turlgo.feature.initKoin
import com.sinjidragon.turlgo.feature.network.login.di.loginDataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }

        initKoin {
            androidLogger()
            androidContext(this@MainActivity)
            androidFileProperties()
            modules(
                loginRepositoryModule,
                loginDataSourceModule
            )
        }
    }
}

