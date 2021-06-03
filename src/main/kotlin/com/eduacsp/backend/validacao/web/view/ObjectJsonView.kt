package com.eduacsp.backend.validacao.web.view

import io.javalin.http.Context

class ObjectJsonView {
    fun render(ctx: Context, model:Any){
        ctx.json(model)
    }
}
