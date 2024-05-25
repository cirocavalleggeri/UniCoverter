package com.example.unicoverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unicoverter.ui.theme.UniCoverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniCoverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConveter()
                }
            }
        }
    }
}
@Composable
fun UnitConveter(){
    Column (modifier = Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Unit Converter")
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {Text("Input")}
        )
        Spacer(modifier=Modifier.height(16.dp))
        Row (

            ){
            Box {
                val context= LocalContext.current
                Button(onClick = {Toast.makeText(context,"Bottone premuto",Toast.LENGTH_LONG).show()  }) {
                    Text(text = "Seleziona")
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="" )

                }
            }
            Spacer(modifier=Modifier.width(32.dp))
            Box {
                val context= LocalContext.current
                Button(onClick = {Toast.makeText(context,"Bottone premuto",Toast.LENGTH_LONG).show()  }) {
                    Text(text = "Seleziona")
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="" )
                }
            }
        }
        Spacer(modifier=Modifier.height(16.dp))
        Text(text = "Risultato: Metri",modifier= Modifier.padding(top = 32.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConveter()
}