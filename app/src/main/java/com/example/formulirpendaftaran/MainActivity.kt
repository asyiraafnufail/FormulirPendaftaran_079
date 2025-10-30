package com.example.formulirpendaftaran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Composable
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
        // Judul ungu di atas
        Text(
            text = "Formulir Pendaftaran",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF9575CD), RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .padding(16.dp)
        )
        // Card putih
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Nama Lengkap
                Text("NAMA LENGKAP", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = nama,
                    onValueChange = {
                        nama = it
                    },
                    placeholder = { Text("Isian nama lengkap") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                // Jenis Kelamin
                Text("JENIS KELAMIN", fontWeight = FontWeight.Bold)
                genderList.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = jenisKelamin == item,
                                onClick = { jenisKelamin = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
                statusList.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = status == item,
                                onClick = { status = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = status == item,
                            onClick = { status = item }
                        )
                        Text(item)
                    }
                }

                // Alamat
                Spacer(modifier = Modifier.height(8.dp))
                Text("ALAMAT", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = alamat,
                    onValueChange = {
                        alamat = it
                    },
                    placeholder = {Text("Alamat lengkap") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                // Tombol Submit
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2))
                ) {
                    Text("Submit", color = Color.White)
                }
            }
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier.height(100.dp).width(300.dp)
        ){
            Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){
                Text(text = "Nama    : "+nama, color = Color.White)
                Text(text = "JK      : "+jenisKelamin, color = Color.White)
                Text(text = "Status  : "+status, color = Color.White)
                Text(text = "Alamat  : "+alamat, color = Color.White)
            }
        }
    }
}