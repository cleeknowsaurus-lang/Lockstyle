package com.custom.lockstyle

import android.app.KeyguardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (keyguardManager.isKeyguardSecure) {
            val intent = keyguardManager.createConfirmDeviceCredentialIntent("Seguridad", "Confirma tu PIN o huella")
            if (intent != null) {
                startActivityForResult(intent, 102)
            }
        } else {
            Toast.makeText(this, "Configura un PIN o huella en tu Samsung", Toast.LENGTH_LONG).show()
        }
    }
}
