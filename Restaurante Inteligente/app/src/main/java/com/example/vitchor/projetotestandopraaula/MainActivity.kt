package com.example.vitchor.projetotestandopraaula

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val priceLabel = findViewById<TextView>(R.id.price_label)

        val priceButton = findViewById<Button>(R.id.price_button)

        val refriToggle = findViewById<ToggleButton>(R.id.toggle_refri)

        val batataToggle = findViewById<ToggleButton>(R.id.toggle_batata)

        val vegetarianoToggle = findViewById<ToggleButton>(R.id.toggle_veggetariano)

        priceButton.setOnClickListener {

            var tipoHamburguer = ""
            var temBatata = false
            var tipoBebida = ""

            if (vegetarianoToggle.isChecked) {
                tipoHamburguer = "Vegetariano"
            } else {
                tipoHamburguer = "Carne"
            }

            if (refriToggle.isChecked) {
                tipoBebida = "Fanta"
            } else {
                tipoBebida = ""
            }

            temBatata = batataToggle.isChecked

            var precoRefeicao = fazerRefeicao(tipoHamburguer, temBatata, tipoBebida)

            priceLabel.text = "Preço: ${precoRefeicao}"
        }

    }

    fun fazerRefeicao(tipoHamburguer: String, temBatata: Boolean, tipoBebida: String):Int {

        var preco = 0

        preco = preco + fazerHamburguer(tipoHamburguer)

        if (temBatata) {
            preco = preco + fazerBatata()
        }

        if (tipoBebida != "") {
            preco = preco + servirBebida(tipoBebida)
        }

        return preco
    }

    fun servirBebida(tipoBebida: String):Int {
        println("Pegar Copo")
        println("Encher Copo com ${tipoBebida}")
        println("Bebida pronta!\n")

        return 10
    }

    fun fazerHamburguer(recheio:String):Int {
        println("Fazer um bolinho de ${recheio}")
        println("Achatar o bolinho")
        println("Fritar o bolinho")
        println("Cortar o pão")
        println("Colocar o bolinho dentro do pão")
        println("Hambúrguer pronto!\n")

        if (recheio == "Carne") {
            return 30
        } else {
            return 20
        }
    }

    fun fazerBatata():Int {
        println("Cortar batata")
        println("Fritar batata")
        println("Temperar batata")
        println("Batata pronta!\n")

        return 15
    }

}
