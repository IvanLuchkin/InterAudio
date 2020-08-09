package com.example.interaudio

import kotlin.math.*

class RatioConverter(var value : Double) {
    private var numerator = 0
    private var denominator = 0

    init {
        convertToNormalFraction()
    }

    private fun convertToNormalFraction() {
        val s = value.toString()
        val digitsDec = s.length - s.indexOf('.') - 1
        var denom = 1
        for (i in 0 until digitsDec) {
            value *= 10
            denom *= 10
        }
        val num = round(value).toInt()
        val gcd = gcd(num, denom)
        this.numerator = num / gcd
        this.denominator = denom / gcd
    }

    private fun gcd(num : Int, denom : Int) : Int {
        return if (denom != 0)
            gcd(denom, num % denom)
        else
            num
    }

    public fun getNumerator() : Int {
        return this.numerator
    }

    public fun getDenominator() : Int {
        return this.denominator
    }

}

fun main() {
    val rc = RatioConverter(0.5)
    println("Numerator = ${rc.getNumerator()}\nDenominator = ${rc.getDenominator()}")
}