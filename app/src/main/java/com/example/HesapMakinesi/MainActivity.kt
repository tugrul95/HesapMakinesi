package com.example.HesapMakinesi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.HesapMakinesi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repeat = false
        var sonuc = 0

        val zeroButton = binding.buttonZero
        val oneButton = binding.buttonOne
        val twoButton = binding.buttonTwo
        val threeButton = binding.buttonThree
        val fourButton = binding.buttonFour
        val fiveButton = binding.buttonFive
        val sixButton = binding.buttonSix
        val sevenButton = binding.buttonSeven
        val eightButton = binding.buttonEight
        val nineButton = binding.buttonNine

        val plusButton = binding.buttonPlus
        val resultScreen = binding.resultScreen
        val bottomScreen = binding.bottomScreen
        val eraseButton = binding.buttonErase
        val resultButton = binding.buttonResult
        val clearButton = binding.buttonClear


        zeroButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("0") }
        oneButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("1") }
        twoButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("2") }
        threeButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("3") }
        fourButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("4") }
        fiveButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("5") }
        sixButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("6") }
        sevenButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("7") }
        eightButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("8") }
        nineButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("9") }
        plusButton.setOnClickListener { resultScreen.text = resultScreen.text.toString().plus("+") }

        eraseButton.setOnClickListener {
            repeat = false
            sonuc = 0
            if (resultScreen.text != null) {
                resultScreen.text = resultScreen.text.toString().dropLast(1)
                if (resultScreen.text.isEmpty()) {
                    bottomScreen.text = null
                }
            }
        }

        resultButton.setOnClickListener {
            val sayilar = resultScreen.text.toString().split("+")
            if (!sayilar.contains("")) {
                if (repeat && resultScreen.text != null) {
                    sonuc += sayilar.lastOrNull()!!.toInt()
                } else {
                    for (sayi in sayilar) {
                        sonuc += sayi.toInt()
                    }
                    repeat = true
                }
                bottomScreen.text = "$sonuc"
            } else {
                Snackbar.make(it, "Lütfen geçerli işlem yapınız.", Snackbar.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            resultScreen.text = null
            bottomScreen.text = null
            repeat = false
            sonuc = 0
        }
    }

    fun throwNotImplemented(view: View) {
        Snackbar.make(view, "Diğer işlemler eklenecektir", Snackbar.LENGTH_SHORT).show()
    }
}