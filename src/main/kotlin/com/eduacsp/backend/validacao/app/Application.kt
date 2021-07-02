package com.eduacsp.backend.validacao.app

import com.eduacsp.backend.validacao.routes.ValidacaoRoutes
import com.eduacsp.backend.validacao.routes.ValidacaoRoutesImpl
import com.eduacsp.backend.validacao.service.ValidacaoService
import com.eduacsp.backend.validacao.service.ValidacaoServiceImpl
import com.eduacsp.backend.validacao.web.ValidacaoController
import io.javalin.Javalin
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

const val PORT = 7000

@OptIn(KoinApiExtension::class)
class Application : KoinComponent {
    private val validacaoRoutes: ValidacaoRoutes by inject()

    fun init(): Javalin {
        val backendModule = module {
            single<ValidacaoRoutes> { ValidacaoRoutesImpl(get()) }
            single { ValidacaoController(get()) }
            single { ValidacaoServiceImpl() }
        }
        startKoin {
            modules(backendModule)
        }

        return Javalin.create().routes {
                validacaoRoutes.register()
            }.start(PORT)
    }
}

fun main(args: Array<String>) {
    Application().init()
}
