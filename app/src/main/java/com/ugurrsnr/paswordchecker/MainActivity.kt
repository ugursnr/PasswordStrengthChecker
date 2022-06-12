package com.ugurrsnr.paswordchecker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import com.ugurrsnr.paswordchecker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val charsUppercase = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
        val charsLowercase = charsUppercase.map {
            it.lowercase()
        }
        val numbers = listOf("1","2","3","4","5","6","7","8","9","0")
        //You can add more special characters
        val specialCharacters = listOf("!", "'", "^","+", "%", "&", "/","(",")","=","?","_","<",">", "£","#","½","{","[","]","}","*",".", ",",":", ";")

        val redColor = ContextCompat.getColor(applicationContext,R.color.red)
        val greenColor = ContextCompat.getColor(applicationContext,R.color.green)

        binding.passwordEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(p0: Editable?) {

                val textToString = p0.toString()
                val textAsList = textToString.map {
                    it.toString()
                }.toList()

                if (textAsList.size < 12) {
                    binding.isPasswordStrongText.text = "Password is weak and short"
                    binding.isPasswordStrongText.setTextColor(redColor.toString().toInt())

                } else if (textAsList.intersect(numbers).isNotEmpty()
                    && textAsList.intersect(specialCharacters).isNotEmpty()
                    && textAsList.intersect(charsLowercase).isNotEmpty()
                    && textAsList.intersect(charsUppercase).isNotEmpty()
                    && textAsList.size >= 12
                ) {
                    binding.isPasswordStrongText.text = "Password is strong"
                    binding.isPasswordStrongText.setTextColor(greenColor.toString().toInt())

                }else{
                    binding.isPasswordStrongText.text = "Password is weak"
                    binding.isPasswordStrongText.setTextColor(redColor.toString().toInt())

                }
            }
        })


    }
}