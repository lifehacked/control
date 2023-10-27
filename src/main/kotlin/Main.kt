import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AppViewModel {
	private val _queryInputFlow = MutableStateFlow("")
	val queryInputFlow: StateFlow<String> get() = _queryInputFlow

	fun query(value: String) {
		_queryInputFlow.value = value
	}

	fun resetQuery() {
		_queryInputFlow.value = ""
	}
}

@Composable
fun MainContent(viewModel: AppViewModel, window: FrameWindowScope) {
	val title by viewModel.queryInputFlow.collectAsState()
	Content(title = title, onInput = {
		viewModel.query(it)
		window.window.title = it
		// TODO do other stuff
	}, onResetClicked = { viewModel.resetQuery() })
}

@Composable
fun Content(
	title: String,
	onInput: (String) -> Unit,
	onResetClicked: () -> Unit,
) {
	MaterialTheme(colors = darkColors()) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(MaterialTheme.colors.background)
				.padding(8.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = title,
				onValueChange = { onInput(it) },
				label = { Text(text = "Title") },
				textStyle = MaterialTheme.typography.body1.copy(color = Color.White),
				singleLine = true
			)
			OutlinedButton(
				onClick = { onResetClicked() },
				modifier = Modifier.padding(16.dp)
			) {
				Text("Reset")
			}

		}
	}
}


fun main() = application {
	Window(onCloseRequest = ::exitApplication) {
		MaterialTheme {
			MainContent(AppViewModel(), this@Window)
		}
	}
}
