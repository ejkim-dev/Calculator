package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setOnButtonClickListener()
        observeViewModel()
    }

    private fun setOnButtonClickListener() {
        binding.apply {
            val numberButtonClickListener = viewModel.numberButtonClickListener()
            val operatorButtonClickListener = viewModel.operatorButtonClickListener()

            buttonOne.setOnClickListener(numberButtonClickListener)
            buttonTwo.setOnClickListener(numberButtonClickListener)
            buttonThree.setOnClickListener(numberButtonClickListener)
            buttonFour.setOnClickListener(numberButtonClickListener)
            buttonFive.setOnClickListener(numberButtonClickListener)
            buttonSix.setOnClickListener(numberButtonClickListener)
            buttonSeven.setOnClickListener(numberButtonClickListener)
            buttonEight.setOnClickListener(numberButtonClickListener)
            buttonNine.setOnClickListener(numberButtonClickListener)
            buttonZero.setOnClickListener(numberButtonClickListener)

            buttonPlus.setOnClickListener(operatorButtonClickListener)
            buttonMinus.setOnClickListener(operatorButtonClickListener)
            buttonDivide.setOnClickListener(operatorButtonClickListener)
            buttonModulo.setOnClickListener(operatorButtonClickListener)
            buttonMultiply.setOnClickListener(operatorButtonClickListener)
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            errorMessage.observe(this@MainActivity, {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            })

            firstValue.observe(this@MainActivity, {
                binding.textViewFirstValue.text = it
            })

            secondValue.observe(this@MainActivity, {
                binding.textViewSecondValue.text = it
            })

            resultValue.observe(this@MainActivity, {
                binding.textViewResultValue.text = it
            })
        }
    }

}