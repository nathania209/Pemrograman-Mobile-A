package com.example.tugas1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding property
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Event tombol login
        binding.btnLogin.setOnClickListener {
            val nama = binding.edittxtNamalengkap.text.toString()
            val username = binding.edittxtUsername.text.toString()
            val password = binding.edittxtPassword.text.toString()
            val confirmPassword = binding.edittxtConfirmPassword.text.toString()

            when {
                nama.isBlank() || username.isBlank() || password.isBlank() || confirmPassword.isBlank() -> {
                    Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Password dan Confirm Password tidak cocok!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Login Berhasil\nSelamat datang, $nama!", Toast.LENGTH_LONG).show()

                    // Kosongkan isian setelah login
                    binding.edittxtNamalengkap.text?.clear()
                    binding.edittxtUsername.text?.clear()
                    binding.edittxtPassword.text?.clear()
                    binding.edittxtConfirmPassword.text?.clear()
                }
            }
        }
    }
}
