package com.tekfy.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tekfy.ecommerceappmvvm.presentation.screens.auth.LoginScreen
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.Blue500
import com.tekfy.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme

@Composable
fun DefaultButton(
    modifier: Modifier,
    text:String,
    onClick:() -> Unit,
    color: Color = Blue500,
    icon: ImageVector = Icons.Default.ArrowForward
){
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    )
    {
        Icon(imageVector = icon , contentDescription = "")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    EcommerceAppMVVMTheme {
        //Greeting("Android")
        //LoginContent()
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            //    .padding(top = 20.dp) ,
            text ="Login" ,
            onClick = {  }
        )
    }
}