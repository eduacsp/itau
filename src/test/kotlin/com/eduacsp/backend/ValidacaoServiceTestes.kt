package com.eduacsp.backend

import com.eduacsp.backend.validacao.domain.RetornoValidacao
import com.eduacsp.backend.validacao.service.ValidacaoService
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidacaoServiceTestes {

    private val validacaoService = mockk<ValidacaoService>(relaxed = true)

    companion object {
        const val PASSWD_VALID = "AbTp9!fok"
        const val PASSWD_INVALID_LESS_NINE = "AbTp9!fo"
        const val PASSWD_INVALID_WITHOUT_DIGIT = "AbTpa!fok"
        const val PASSWD_INVALID_WITHOUT_CAPITAL_CASE = "abtp9!fok"
        const val PASSWD_INVALID_WITHOUT_LOWER_CASE = "ABTP9!FOK"
        const val PASSWD_INVALID_WITHOUT_SPECIAL_CHARS = "AbTp9afok"
        const val PASSWD_INVALID_WITHOUT_REPETED_CHARS = "AbTp9!fkk"
        const val PASSWD_INVALID_WHITE_SPACES = "AbTp9!  k"
    }

    @Test
    fun `test password validation with Ok return`() {
        val retornoValidacao = RetornoValidacao(true)
        every{validacaoService.isValid(PASSWD_VALID) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_VALID)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password with less than 9 digits`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_LESS_NINE) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_LESS_NINE)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password without one digit`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WITHOUT_DIGIT) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WITHOUT_DIGIT)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password without capital case`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WITHOUT_CAPITAL_CASE) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WITHOUT_CAPITAL_CASE)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password without lower case`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WITHOUT_LOWER_CASE) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WITHOUT_LOWER_CASE)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password without special chars`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WITHOUT_SPECIAL_CHARS) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WITHOUT_SPECIAL_CHARS)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password without repeted chars`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WITHOUT_REPETED_CHARS) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WITHOUT_REPETED_CHARS)
        assertEquals(returnVal, retornoValidacao)
    }

    @Test
    fun `test password with white spaces`() {
        val retornoValidacao = RetornoValidacao(false)
        every{validacaoService.isValid(PASSWD_INVALID_WHITE_SPACES) } returns retornoValidacao
        val returnVal = validacaoService.isValid(PASSWD_INVALID_WHITE_SPACES)
        assertEquals(returnVal, retornoValidacao)
    }

}
