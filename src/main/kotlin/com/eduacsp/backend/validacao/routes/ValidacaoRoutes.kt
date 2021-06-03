package com.eduacsp.backend.validacao.routes

import com.eduacsp.backend.validacao.web.ValidacaoController
import com.eduacsp.backend.validacao.web.view.ObjectJsonView
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post

interface ValidacaoRoutes {
    fun register()
}

class ValidacaoRoutesImpl(private val validacaoController: ValidacaoController) : ValidacaoRoutes {
    private var jsonView = ObjectJsonView()
    override fun register(){
        path("validate"){
            post{ctx-> jsonView.render(ctx,validacaoController.validatePassword(ctx))}
        }
    }
}
