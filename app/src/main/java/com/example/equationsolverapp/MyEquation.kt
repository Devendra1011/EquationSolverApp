package com.example.equationsolverapp

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.equationsolverapp.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MyEquation(var binding: ActivityMainBinding) : BaseObservable() {


    @Bindable
    var a: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.a)
        }

    @Bindable
    var b: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.b)
        }

    @Bindable
    var c: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.c)
        }

    fun solveEquation(view: View) {
        // converting string to integers
        var a = a.toInt()
        var b = b.toInt()
        var c = c.toInt()

        // Calculating the Discriminant
        var discriminant = ((b * b) - (4 * a * c))

        // Finding the solutions
        var x1: Double
        var x2: Double
        if (discriminant > 0) {
            // two real and distinct roots
            x1 = (-b + sqrt(discriminant.toDouble())) / (2 * a)
            x2 = (-b - sqrt(discriminant.toDouble())) / (2 * a)

            // display the result in textView
            binding.tvResult.text = "X1 = $x1 + , X2 = $x2"

        } else if (discriminant < 0) {
            // no real roots
            binding.tvResult.text = "No Real Roots (Complex Roots)"

        } else {
            // d =0
            // one real soln
            x1 = (-b / (2 * a)).toDouble()
            binding.tvResult.text = "x = $x1"
        }


    }


}