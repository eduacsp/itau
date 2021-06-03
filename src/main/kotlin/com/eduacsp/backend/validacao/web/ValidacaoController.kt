package com.eduacsp.backend.validacao.web

import com.eduacsp.backend.validacao.domain.RetornoValidacao
import com.eduacsp.backend.validacao.service.ValidacaoService
import io.javalin.http.Context
import org.slf4j.LoggerFactory

class ValidacaoController(val service: ValidacaoService) {
    val logger = LoggerFactory.getLogger(ValidacaoController::class.java)

    fun validatePassword(ctx: Context): RetornoValidacao {
        val password = ctx.header("password")

        logger.info("password: ${password}")
        
        return service.isValid(password)
    }

}
