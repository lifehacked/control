package de.life.hacked

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel {
	private val _queryInputFlow = MutableStateFlow("")
	val queryInputFlow: StateFlow<String> get() = _queryInputFlow

	fun query(value: String) {
		_queryInputFlow.value = value
	}

	fun resetQuery() {
		_queryInputFlow.value = ""
	}
}