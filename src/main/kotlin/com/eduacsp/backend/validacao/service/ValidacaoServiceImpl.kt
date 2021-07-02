package com.eduacsp.backend.validacao.service

import com.eduacsp.backend.validacao.domain.RetornoValidacao
import org.slf4j.LoggerFactory
import java.util.regex.Matcher
import java.util.regex.Pattern

const val PASSWORD_LENGTH = 9

class ValidacaoServiceImpl: ValidacaoService {
    val logger = LoggerFactory.getLogger(ValidacaoService::class.java)

    val passwordPattern: String =
        "^(?=.*[0-9])(?!(.*(.)\\1+))(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#\$%^&()*+=])(?=\\S+\$).{4,}\$"

    override fun isValid(password: String?): RetornoValidacao {
        val pattern: Pattern = Pattern.compile(passwordPattern);

        val isValid = password != null
                && password.length >= PASSWORD_LENGTH
                && pattern.matcher(password).matches()
                && !thereIsDuplicateChars(password)

        logger.info("isValid: ${password} - ${isValid}")
        return RetornoValidacao(isValid)
    }

    private fun thereIsDuplicateChars(password: String): (Boolean) {
        var isDuplicate = false
        val password = password.toLowerCase()
        val map = HashMap<Char, Int>()
        for (i in password.toCharArray()) {
            if (map.keys.contains(i)) {
                isDuplicate = true
                break
            } else {
                map[i] = 1
            }
        }
        return isDuplicate
    }

}
