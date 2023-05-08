package com.retro.ondc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.retro.py.ExposeUseModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ExposeUseModule.initializePython(this)
        displayPythonResult()
    }

    private fun displayPythonResult() {
        val helloMessage = ExposeUseModule.callPythonFunction()
        Toast.makeText(this, helloMessage, Toast.LENGTH_LONG).show()
    }

}