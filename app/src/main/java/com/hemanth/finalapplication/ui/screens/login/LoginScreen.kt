package com.hemanth.finalapplication.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hemanth.finalapplication.ui.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Column (modifier = Modifier
        .background(Color(0xFF0A3D91))
        .fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(0.2f))
            Text(
                text = "Welcome",
                fontSize = 25.sp,
                modifier = Modifier
                    .weight(.5f),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White) },
                singleLine = true,
                isError = emailError,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                )
            )
            if (emailError) {
                Text(text = "Invalid email", color = Color.Red)
                Text(text = "Email should contain @, .com", color = Color.Red)
            }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                singleLine = true,
                isError = passwordError,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                )
            )
            if (passwordError) {
                Text(text = "Password should be at least 6 characters", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    emailError = !email.contains("@") || !email.contains(".com")
                    passwordError = password.length < 6

                    if (!emailError && !passwordError) {
                        navController.navigate(Navigation.HOME.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors( Color(0xFFFF6F00))
            ) {
                Text("Login", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate(Navigation.SIGN_IN.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors( Color(0xFFFF6F00))
            ) {
                Text("Create an Account", color = Color.White)
            }

            Spacer(modifier = Modifier.weight(0.3f))

        }
    }
}