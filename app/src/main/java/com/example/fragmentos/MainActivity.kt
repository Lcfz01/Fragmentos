package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private var fragmentoActual : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragmento2 = findViewById<Button>(R.id.af2)
        val btnFragmento3 = findViewById<Button>(R.id.af3)

        if (savedInstanceState != null){
            if(savedInstanceState.getString("fragmento") == "fragmento1"){
                actualizaFragmento(Fragmento1(),"fragmento1")
            }
            else if (savedInstanceState.getString("fragmento") == "fragmento2"){
                actualizaFragmento(Fragmento1(),"fragmento2")
            }
            else if (savedInstanceState.getString("fragmento") == "fragmento3"){
                actualizaFragmento(Fragmento1(),"fragmento3")
            }
        }else{
            actualizaFragmento(Fragmento1(),"fragmento1")
        }

        btnFragmento2.setOnClickListener {
            actualizaFragmento(Fragmento2(),"fragmento2")
        }

        btnFragmento3.setOnClickListener {
            actualizaFragmento(Fragmento3(),"fragmento3")
        }
    }
     fun actualizaFragmento(fragmento: Fragment, etiqueta:String){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentos, fragmento)
        transaction.commit()
         fragmentoActual = etiqueta
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

}