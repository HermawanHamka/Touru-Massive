package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class BuktiPembayaranActivity : AppCompatActivity() {
    private val PICK_FILE_REQUEST_CODE = 1

    private lateinit var btnChooseFile: ImageButton
    private lateinit var btnUnggah: Button
    private var filePath: String? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bukti_pembayaran)
        val backButton: ImageView = findViewById<ImageView>(R.id.imgBackBuktiPembayaran)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnChooseFile = findViewById(R.id.btnChooseFile)
        btnUnggah = findViewById(R.id.btnUnggah)

        btnChooseFile.setOnClickListener {
            // Launch the file picker intent
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*" // Set the MIME type to select any file type
            startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
        }

        btnUnggah.setOnClickListener {
            if (filePath != null) {
                // Perform the upload process using the file path
                // Replace this with your actual upload implementation
                uploadFile(filePath!!)
            } else {
                Toast.makeText(this, "Please choose a file first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val uri: Uri? = data.data
            filePath = uri?.path // Get the file path from the URI
        }
    }

    private fun uploadFile(filePath: String) {
        // Implement your file upload logic here
        // Use the provided filePath to access the selected file and upload it
        Toast.makeText(this, "Uploading file: $filePath", Toast.LENGTH_SHORT).show()
        // Add your code to upload the file to the server or perform other necessary actions
    }
//        val btnLanjut = findViewById<Button>(R.id.btnLanjut)
//        btnLanjut.setOnClickListener {
//            val pindahPembayaran = Intent(this, Pembayaran2Activity::class.java)
//            startActivity(pindahPembayaran)
//        }
    }
