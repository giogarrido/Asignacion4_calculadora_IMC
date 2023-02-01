package mx.edu.itson.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Variables
    var IMC: Double = 0.0
    var peso: Double = 0.0
    var altura: Double = 0.0
    var new = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular: Button = findViewById(R.id.btnCalcular)
        val tvIMC: TextView = findViewById(R.id.tvIMC)
        val etPeso: EditText = findViewById(R.id.etPeso)
        val etEstatura: EditText = findViewById(R.id.etEstatura)

        //evento button clic o cliclisterer
        calcular.setOnClickListener {


            if (etPeso.text.isEmpty() || etEstatura.text.isEmpty()) {
                tvIMC.setText("Ingrese un valor")
            } else {
                peso = etPeso.text.toString().toDouble()
                altura = etEstatura.text.toString().toDouble()

                IMC = peso / altura.pow(2)
                tvIMC.setText(String.format("%.2f", IMC))

            }


        }
    }


}