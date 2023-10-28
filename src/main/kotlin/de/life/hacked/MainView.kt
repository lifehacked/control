package de.life.hacked

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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


@Composable
fun MainContent(viewModel: MainViewModel, window: FrameWindowScope) {
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
	Box(
		modifier = Modifier.background(MaterialTheme.colors.background.copy(alpha = 0.5f))
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(MaterialTheme.colors.background)
				.padding(8.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Header()
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

@Composable
fun Header() {
	TODO("show logo")
}


fun main() = application {
	Window(onCloseRequest = ::exitApplication) {
		MaterialTheme(colors = darkColors()) {
			MainContent(MainViewModel(), this@Window)
		}
	}
}
