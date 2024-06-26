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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unicoverter.ui.theme.UniCoverterTheme
import java.time.format.TextStyle
import kotlin.math.roundToInt


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
    var inputValue by  remember { mutableStateOf("") }
    var outputValue by  remember { mutableStateOf("") }
    var inputUnnit by  remember { mutableStateOf("Metri") }
    var outputUnit by  remember { mutableStateOf("Metri") }
    var iExplanded by  remember { mutableStateOf(false) }
    var oExplanded by  remember { mutableStateOf(false) }
    val conversionFactor =  remember { mutableStateOf(1.0) }
    val oconversionFactor =  remember { mutableStateOf(1.0) }
    val customStyle= androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        color = Color.Red,
        fontSize = 32.sp

    )
    fun convertUnit(){
        val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0
        val risultato = ((conversionFactor.value*inputValueDouble*100/oconversionFactor.value))/100
       //outputValue=String.format("%.2f",risultato)
        outputValue=risultato.toString()
    }
    Column (modifier = Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Unit Converter", style = customStyle)
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {inputValue=it
                             convertUnit()}
            ,label = {Text("Enter value")
            }
        )
        Spacer(modifier=Modifier.height(16.dp))
        Row (

            ){
            // inputBox
            Box {
                val context= LocalContext.current
                Button(onClick = {Toast.makeText(context,"Bottone premuto",Toast.LENGTH_LONG).show()
                                  iExplanded=!iExplanded}) {
                    Text(text = inputUnnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="" )

                }
                DropdownMenu(expanded = iExplanded, onDismissRequest = {  iExplanded=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimetri") },
                                                   onClick = {

                                                       iExplanded=!iExplanded
                                                       inputUnnit="Centimetri"
                                                       conversionFactor.value=0.01
                                                       convertUnit()
                                                   })
                    DropdownMenuItem(text = { Text(text = "Metri") },
                        onClick = { iExplanded=!iExplanded
                            inputUnnit="Metri"
                            conversionFactor.value=1.0
                            convertUnit()})
                    DropdownMenuItem(text = { Text(text = "Piedi") },
                        onClick = {iExplanded=!iExplanded
                            inputUnnit="Piedi"
                            conversionFactor.value=0.3408
                            convertUnit() })
                    DropdownMenuItem(text = { Text(text = "Millimetri") },
                        onClick = {iExplanded=!iExplanded
                            inputUnnit="Millimetri"
                            conversionFactor.value=0.001
                            convertUnit() })
                }
            }
            Spacer(modifier=Modifier.width(32.dp))
            //outputBox
            Box {
                val context= LocalContext.current
                Button(onClick = {Toast.makeText(context,"Bottone premuto",Toast.LENGTH_LONG).show()
                                  oExplanded=!oExplanded

                                    }

                                    ) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="" )
                }
                DropdownMenu(expanded =  oExplanded, onDismissRequest = { oExplanded=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimetri") },
                        onClick = { oExplanded=false
                            outputUnit="Centimetri"
                            oconversionFactor.value=0.01
                            convertUnit() })
                    DropdownMenuItem(text = { Text(text = "Metri") },
                        onClick = { oExplanded=false
                            outputUnit="Metri"
                            oconversionFactor.value=1.00
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text(text = "Piedi") },
                        onClick = { oExplanded=false
                            outputUnit="Piedi"
                            oconversionFactor.value=0.3048
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text(text = "Millimetri") },
                        onClick = {oExplanded=false
                            outputUnit= "Millimetri"
                            oconversionFactor.value=0.001
                            convertUnit()

                        })
                }
            }
        }
        Spacer(modifier=Modifier.height(16.dp))
        Text(text = "Risultato: $outputValue $outputUnit",modifier= Modifier.padding(top = 32.dp),
            style = MaterialTheme.typography.headlineMedium)
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConveter()
}