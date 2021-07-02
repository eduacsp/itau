package com.eduacsp.backend.validacao.service

import com.eduacsp.backend.validacao.domain.RetornoValidacao

interface ValidacaoService {

    fun isValid(password: String?): RetornoValidacao

}