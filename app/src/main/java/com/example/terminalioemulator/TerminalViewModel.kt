package com.example.terminalioemulator

import android.text.Editable
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TerminalViewModel: ViewModel() {
    private val TAG = "${TerminalEmulatorApplication.TAG}TerminalViewModel"

    val terminalTextFlow = MutableSharedFlow<Editable>(1, 10, BufferOverflow.DROP_OLDEST).apply {
        tryEmit(Editable.Factory.getInstance().newEditable(""))
    }
    val terminalEditTextFlow = MutableSharedFlow<Editable>(1, 1, BufferOverflow.DROP_OLDEST).apply {
        tryEmit(Editable.Factory.getInstance().newEditable(""))
    }
    val terminalReadFlow = MutableSharedFlow<String>(0, 1, BufferOverflow.DROP_OLDEST)

    fun print(args: Array<String>):Job = viewModelScope.launch {
        Log.d(TAG, "print")
        val editableTextView = Editable.Factory.getInstance().newEditable("")
        val editableEditView = Editable.Factory.getInstance().newEditable("")
        args.forEach {
            if (it.endsWith(System.getProperty("line.separator"))) {
                editableTextView.append(it)
            } else {
                editableEditView.append(it)
            }
        }

        terminalTextFlow.emit(editableTextView)
        terminalEditTextFlow.emit(editableEditView)
    }

    fun onStop() {
        Log.d(TAG, "onStop")
        terminalTextFlow.tryEmit(Editable.Factory.getInstance().newEditable(""))
    }
}