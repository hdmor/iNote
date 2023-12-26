package com.i.note.feature_note.presentation.notes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultRadioButton(text: String, selected: Boolean, onSelect: () -> Unit, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.clickable { onSelect() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
//            colors = RadioButtonDefaults.colors(
//                selectedColor = MaterialTheme.colorScheme.primary,
//                unselectedColor = MaterialTheme.colorScheme.background
//            )
        )
//        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(end = 16.dp))
    }
}