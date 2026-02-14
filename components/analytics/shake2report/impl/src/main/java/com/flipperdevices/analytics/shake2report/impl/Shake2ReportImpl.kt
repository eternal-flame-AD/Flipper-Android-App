package com.flipperdevices.analytics.shake2report.impl

import android.app.Application
import com.flipperdevices.core.di.AppGraph
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

private const val FILE_LOG_DIR = "log"
private const val FILE_LOG_SIZE = 1 * 1024 * 1024 // 1 MB
private const val FILE_LOG_LIMIT = 10

@Singleton
@ContributesBinding(AppGraph::class, InternalShake2Report::class)
class Shake2ReportImpl @Inject constructor(
    private val application: Application
) : InternalShake2Report {
    private val alreadyRegistered = MutableStateFlow(false)

    override val logDir: File by lazy { File(application.cacheDir, FILE_LOG_DIR) }

    override fun register() {
        return
    }

    override fun setExtra(tags: List<Pair<String, String>>) {
    }

    override fun getIsRegisteredFlow() = alreadyRegistered.asStateFlow()
}
