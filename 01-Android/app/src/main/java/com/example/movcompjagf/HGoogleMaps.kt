package com.example.movcompjagf

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap

class HGoogleMaps : AppCompatActivity() {
    private lateinit var mapa: GoogleMap
    var permisos = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hgoogle_maps)
    }

    fun solicitarPermisos() {
        val contexto = this.applicationContext
        val permisoFineLocation = ContextCompat.checkSelfPermission(
            contexto,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        val tienePermisos = permisoFineLocation == PackageManager.PERMISSION_GRANTED

        if (tienePermisos) {
            permisos = true
        } else {
            ActivityCompat.requestPermissions(
                this, // Contexto
                arrayOf( // Arreglo de Permisos
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1 // Codigo de peticion de los permisos
            )
        }
    }
}