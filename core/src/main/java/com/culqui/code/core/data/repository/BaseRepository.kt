package com.culqui.code.core.data.repository

import com.culqui.code.core.data.remote.SafeApiRequest
import org.koin.core.component.KoinComponent

open class BaseRepository : SafeApiRequest(), KoinComponent{
}