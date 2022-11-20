package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aqui onde vc decide o q o app vai fazer...
        setContentView(R.layout.activity_main)

        // buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // opcao 1: via XML
        // opcao 2: criar uma variavel que seja do tipo (objeto anonimo) View.OnClickListener (interface)

        // opcao 3: - mais simples -
        // declarar diretamente o bloco de código que será disparado pelo onClickListener
        btnGenerate.setOnClickListener {
            // aqui podemos colocar nossa lógica de programação.
            // será disparado depois do evento de touch do usuário

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
    // validar quando o campo é vazio


    // validar se o campo informado é entre 6 e 15
        // isNotEmpty = se o campo não for vazio
        if (text.isNotEmpty()) {

            // validar se o campo informado é entre 6 e 15
            val qtd = text.toInt() // toInt() = convert string para inteiro

            if (qtd >= 6 && qtd <= 15){
                // gerando números aleatórios
                    val numbers = mutableSetOf<Int>()
    // classe Random irá gerar números aleátorios
               val random = Random()

                while(true) {
                    // máximo de números até 60 (de 0 a 59)
                    val number = random.nextInt(60)
                    numbers.add(number + 1) // para não contar o 0

                    if (numbers.size == qtd) {
                        break
                    }
                }
        // Adicionando um separador entre os números
                txtResult.text = numbers.joinToString(" - ")



    // este código é para testar a lógica no console
//                for (x in numbers) {
//                    Log.i("Teste", "número que saiu: $x")
//                }
            } else {
    // Toast = é um mensageiro que aparecerá na tela durante um tempo que é o Toast.LENGTH_LONG
        // tempo do toast é padrão do android tendo duas opções
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            }

        } else {
// Toast é uma classe
    // makeText pede 3 parâmentros
        // this é o próprio objeto mainActivity lá da linha 12
            // show -> vai mostrar o campo na tela
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }
    }

}









//btnGenerate.setOnClickListener(buttonClickListener)

// opcao 2: criar uma variavel que seja do tipo (objeto anonimo) View.OnClickListener (interface)
// método simplicado
//val buttonClickListener = View.OnClickListener {
//    Log.i("Teste", "botão clicado!!!")
//}


    // metódo grande
//    val buttonClickListener = object : View.OnClickListener {
//// quem chama o onClick é o próprio SDK do android que dispara o evento de touch
//        override fun onClick(v: View?) {
//            Log.i("Teste", "botão clicado!!!")
//        }






    // opcao 1: via XML -> criar função que dispara eventos de click
//    fun buttonClicked(view: View) {
//        Log.i("Teste", "botão clicado!!!")
//    } // colocar em activity_main no button -> android:onClick="buttonClicked"
//
//}