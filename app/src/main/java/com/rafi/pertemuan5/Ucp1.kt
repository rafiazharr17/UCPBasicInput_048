package com.rafi.pertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ucp(modifier: Modifier = Modifier){
    var textName by remember { mutableStateOf("") }
    var textTelp by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")

    var name by remember { mutableStateOf("") }
    var telp by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 40.dp),
    ) {
        header(nama = name)

        Text(
            text = "Yuk lengkapi data dirimu!",
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        OutlinedTextField(
            value = textName,
            onValueChange = {textName = it},
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Isi nama anda")
            },
            leadingIcon ={
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "face"
                )
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
        )

        OutlinedTextField(
            value = textTelp,
            onValueChange = {textTelp = it},
            label = {
                Text("No Handphone")
            },
            placeholder = {
                Text("Isi nomor telpon anda")
            },
            leadingIcon ={
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "phone"
                )
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(top = 15.dp, end = 15.dp, start = 15.dp)
        )

        Text(
            text = "Jenis Kelamin",
            modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                .align(alignment = Alignment.Start)
        )

        Row{
            listJK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        },
                        modifier = Modifier.padding(start = 12.dp)
                    )
                    Text(item)
                }
            }
        }

        Button(
            onClick = {
                name = textName
                telp = textTelp
                jenis = textJK
            },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue))
        ) {
            Text(
                text = "Simpan"
            )
        }

        Card(
            colors = CardDefaults.cardColors(Color.LightGray),
            modifier = Modifier.padding(15.dp)
                .fillMaxWidth()
        ) {
            tampilData(
                nomor = telp,
                jk = jenis
            )
        }
    }
}

@Composable
fun header(nama: String){
    Box(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(bottomEnd = 50.dp))
            .background(colorResource(id = R.color.blue)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu",
                    tint = Color.White,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                )

                Text(
                    text = "Halo,",
                    modifier = Modifier.padding(top = 20.dp, start = 15.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Text(
                    text = nama,
                    modifier = Modifier.padding(top = 5.dp, start = 15.dp, bottom = 20.dp),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            Column(
                modifier = Modifier.padding(end = 15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.potorapi),
                    contentDescription = "foto",
                    modifier = Modifier.size(50.dp)
                        .clip(shape = CircleShape)
                )
            }

        }
    }
}

@Composable
fun tampilData(
    nomor: String,
    jk: String,
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Nomor Handphone",
            fontSize = 15.sp
        )

        Card (
            colors = CardDefaults.cardColors(colorResource(id = R.color.blue))
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "phone",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                        .size(40.dp)
                )
                Text(
                    text = ":",
                    color = Color.White,
                    modifier = Modifier.weight(0.2f),
                    fontSize = 25.sp
                )
                Text(
                    text = nomor,
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Jenis Kelamin",
            fontSize = 15.sp,
        )

        Card(
            colors = CardDefaults.cardColors(colorResource(id = R.color.blue))
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "person",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                        .size(40.dp)
                )
                Text(
                    text = ":",
                    color = Color.White,
                    modifier = Modifier.weight(0.2f),
                    fontSize = 25.sp
                )
                Text(
                    text = jk,
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                    color = Color.White
                )
            }
        }
    }
}


