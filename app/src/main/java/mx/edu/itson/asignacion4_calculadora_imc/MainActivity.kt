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
        val tvIMC: TextView = findViewById(R.id.imc)
        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val tvRango: TextView = findViewById(R.id.rango)

        //evento button clic o cliclisterer
        calcular.setOnClickListener {


            if (weight.text.isEmpty() || height.text.isEmpty()) {
                tvIMC.setText("Ingrese un valor")
            } else {
                peso = weight.text.toString().toDouble()
                altura = height.text.toString().toDouble()

                IMC = peso / altura.pow(2)
                tvIMC.setText(String.format("%.1f", IMC))
                tvRango.setText(rango(IMC))

            }


        }
    }

    fun rango (imc:Double): String {

        if(imc<18.5){
            return "Bajo peso"
        }else if(imc>=18.5 && imc<=24.9){
            return "Normal"
        }else if (imc>=25 && imc<=29.9){
            return "Sobrepeso"
        }else if (imc>=30 && imc<=34.9){
            return "Obesidad grado 1"
        } else if (imc>=35 && imc<=39.9){
            return "Obesidad grado 2"
        } else {
            return "Obesidad grado 3"
        }

    }


}