package com.example.terminalioemulator

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.terminalioemulator.databinding.ActivityMainBinding
import com.example.terminalioemulator.emulator.JavaEmulator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val TAG = "${TerminalEmulatorApplication.TAG}MainActivity"

    private lateinit var binding: ActivityMainBinding
    private val emulatorScope: CoroutineScope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())
    val viewModel: TerminalViewModel by viewModels()

    private var isFirstStart = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textInputEditLayout.setOnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN) {
                when(i) {
                    KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER -> {
                        val prefix = binding.textInputLayout.prefixText
                        val message = binding.textInputEditLayout.text
                        val messageText = message.toString()
                        IOEmulator.println("${prefix?: ""}$message")
                        binding.textInputEditLayout.editableText.clear()
                        binding.textInputLayout.prefixText = ""
                        viewModel.terminalReadFlow.tryEmit(messageText)
                        return@setOnKeyListener true
                    }
                }
            }
            return@setOnKeyListener false
        }

        IOEmulator.viewModel = viewModel
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.terminalTextFlow.onEach{
                    if (it.isNotEmpty()) {
                        binding.textViewTerminal.append(it)
                    }
                }.launchIn(this)
                viewModel.terminalEditTextFlow.onEach {
                    if (it.isNotEmpty()) {
                        binding.textInputLayout.prefixText = it
                    }
                }.launchIn(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (isFirstStart) {
            isFirstStart = false
            emulatorScope.launch {
                JavaEmulator.mainEmulator(arrayOf())
            }
        }
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
        viewModel.onStop()
    }
}