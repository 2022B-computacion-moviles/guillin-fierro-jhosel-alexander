package com.example.movcompjagf

class BEntrenador(val nombre: String, val descripcion: String) {
    override fun toString(): String {
        return "${nombre} - ${descripcion}"
    }
}