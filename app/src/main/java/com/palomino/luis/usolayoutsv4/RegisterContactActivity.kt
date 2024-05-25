package com.palomino.luis.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterContactActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_contact)

        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etPhone = findViewById(R.id.etPhone)
        etAddress = findViewById(R.id.etAddress)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val lastName = etLastName.text.toString()
            val phone = etPhone.text.toString()
            val address = etAddress.text.toString()

            if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                return@setOnClickListener
            }

            val intent = Intent(this, ContactDetailsActivity::class.java).apply {
                putExtra("NAME", name)
                putExtra("LAST_NAME", lastName)
                putExtra("PHONE", phone)
                putExtra("ADDRESS", address)
            }
            startActivity(intent)
        }
    }
}
