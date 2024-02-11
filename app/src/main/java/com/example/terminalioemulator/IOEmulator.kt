package com.example.terminalioemulator

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object IOEmulator {
    private val TAG = "${TerminalEmulatorApplication.TAG}IOEmulator"

    var viewModel: TerminalViewModel? = null

    fun print(args: Array<String>) {
        viewModel?.print(args)
    }

    fun println(args: Array<String>) {
        for (i in args.indices) {
            args[i] = args[i].plus(System.getProperty("line.separator"))
        }
        print(args)
    }

    fun <T> read(type: Class<*>): T? {
        var s: String
        runBlocking {
            s = viewModel?.terminalReadFlow?.first() ?: ""
        }
        val out: T?
        when(type) {
            JavaHelper.getIntegerClass() -> {
                out = s.toInt() as T
            }
            JavaHelper.getDoubleClass() -> {
                out = s.toDouble() as T
            }
            JavaHelper.getBooleanClass() -> {
                out = s.toBoolean() as T
            }
            JavaHelper.getFloatClass() -> {
                out = s.toFloat() as T
            }
            JavaHelper.getStringClass() -> {
                out = s as T
            }
            JavaHelper.getCharClass() -> {
                out = s[0] as T
            }
            else -> {
                out = null
            }
        }
        return out
    }

    fun println(string: String) {
        println(arrayOf(string))
    }

    fun print(string: String) {
        print(arrayOf(string))
    }

    fun print(integer: Int) {
        print(arrayOf(integer.toString()))
    }

    fun print(double: Double) {
        print(arrayOf(double.toString()))
    }

    fun print(char: Char) {
        print(arrayOf(char.toString()))
    }

    fun print(boolean: Boolean) {
        print(arrayOf(boolean.toString()))
    }

    fun print(float: Float) {
        print(arrayOf(float.toString()))
    }
}