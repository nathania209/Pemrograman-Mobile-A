package com.example.tugas1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaLengkap = findViewById<EditText>(R.id.edittxtNamalengkap)
        val username = findViewById<EditText>(R.id.edittxtUsername)
        val password = findViewById<EditText>(R.id.edittxtPassword)
        val confirmPassword = findViewById<EditText>(R.id.edittxtConfirmPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val nama = namaLengkap.text.toString()
            val user = username.text.toString()
            val pass = password.text.toString()
            val confirm = confirmPassword.text.toString()

            when {
                nama.isBlank() || user.isBlank() || pass.isBlank() || confirm.isBlank() -> {
                    Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                }
                pass != confirm -> {
                    Toast.makeText(this, "Password dan Confirm Password tidak cocok!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Login Berhasil\nSelamat datang, $nama!", Toast.LENGTH_LONG).show()

                    //Kosongkan field setelah klik login
                    namaLengkap.text.clear()
                    username.text.clear()
                    password.text.clear()
                    confirmPassword.text.clear()
                }
            }
        }
    }
}