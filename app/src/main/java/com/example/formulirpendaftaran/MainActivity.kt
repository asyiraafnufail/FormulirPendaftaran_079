package com.example.formulirpendaftaran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFEDE7F6)
            ) {
                FormulirPendaftaran()
            }
        }
    }
}

fun FormulirPendaftaran() {
    // variabel input
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {