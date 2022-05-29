package com.example.calculator

import android.view.View
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.ArithmeticException

class MainViewModel: ViewModel() {

    private val _errorMessage by lazy { MutableLiveData<String>() }
    val errorMessage: LiveData<String>
    get() = _errorMessage

    private val _firstValue by lazy { MutableLiveData("") }
    val firstValue: LiveData<String>
    get() = _firstValue

    private val _secondValue by lazy { MutableLiveData("") }
    val secondValue: LiveData<String>
    get() = _secondValue

    private val _resultValue by lazy { MutableLiveData("") }
    val resultValue: LiveData<String>
    get() = _resultValue

    fun numberButtonClickListener() : View.OnClickListener {
        return View.OnClickListener {
            when (it) {
                is Button -> setTextView(it.text.toString())
                else -> _errorMessage.postValue("버튼이 아닙니다!")
            }
        }
    }

    fun operatorButtonClickListener(): View.OnClickListener {
        return View.OnClickListener {
            val pairNum: Pair<Int, Int> = try {
                Pair(firstValue.value?.toInt() ?: 0, secondValue.value?.toInt() ?: 0)
            } catch (e : NumberFormatException){
                _errorMessage.postValue("숫자를 눌러주세요")
                return@OnClickListener
            }
            when(it) {
                is Button -> {
                        val resultNum = operationValue(pairNum, it.text.toString())
                        _resultValue.postValue(resultNum?.toString() ?: "연산이 불가능 한 값입니다.")
                    }
                else -> _errorMessage.postValue("버튼이 아닙니다!")
            }
        }
    }

    private fun operationValue (pair: Pair<Int, Int>, operator: String) : Int? {
        return try {
            when (operator) {
                "+" -> pair.first + pair.second
                "-" -> pair.first - pair.second
                "/" -> pair.first / pair.second
                "%" -> pair.first % pair.second
                "*" -> pair.first * pair.second
                else -> null
            }
        } catch (e: ArithmeticException) {
            null
        }
    }

    private fun setTextView(value: String) {
        when {
            firstValue.value.isNullOrEmpty() -> _firstValue.postValue(value)
            secondValue.value.isNullOrEmpty() -> _secondValue.postValue(value)
            resultValue.value.isNullOrEmpty() -> _errorMessage.postValue("연산자를 입력하세요")
            else -> {
                _firstValue.postValue("")
                _secondValue.postValue("")
                _resultValue.postValue("")
            }
        }
    }
}