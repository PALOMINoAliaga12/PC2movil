package com.palomino.luis.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvProducts: TextView
    private lateinit var tvLocation: TextView
    private lateinit var iconCall: ImageView
    private lateinit var iconWhatsApp: ImageView
    private lateinit var iconMaps: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        tvName = findViewById(R.id.tvName)
        tvPhone = findViewById(R.id.tvNumber)
        tvAddress = findViewById(R.id.tvAddress)
        tvProducts = findViewById(R.id.tvProducts)
        tvLocation = findViewById(R.id.tvLocation)
        iconCall = findViewById(R.id.iconCall)
        iconWhatsApp = findViewById(R.id.iconWhatsApp)
        iconMaps = findViewById(R.id.iconMaps)

        val name = intent.getStringExtra("NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val phone = intent.getStringExtra("PHONE")
        val address = intent.getStringExtra("ADDRESS")

        tvName.text = "$name $lastName"
        tvPhone.text = phone
        tvAddress.text = address
        tvProducts.text = "Productos"
        tvLocation.text = "Ubicación"

        iconCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(callIntent)
        }

        iconWhatsApp.setOnClickListener {
            val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$phone?text=Hola%20$name")
            }
            startActivity(whatsappIntent)
        }

        iconMaps.setOnClickListener {
            val mapsIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$address")
            }
            startActivity(mapsIntent)
        }
    }
}
