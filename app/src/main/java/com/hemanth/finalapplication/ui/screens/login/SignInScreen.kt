package com.hemanth.finalapplication.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
@Preview
@Composable
fun SignInScreen(navController: NavHostController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }

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
                text = "Create an account to sign in",
                fontSize = 25.sp,
                modifier = Modifier
                    .weight(.5f),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text(text = "Username", color = Color.White) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                )
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

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("confirm Password", color = Color.White) },
                singleLine = true,
                isError = confirmPasswordError,
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
            if (confirmPasswordError) {
                Text(text = "Passwords do not match", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    emailError = !email.contains("@") || !email.contains(".com")
                    passwordError = password.length < 6
                    confirmPasswordError = password != confirmPassword
                    if (!emailError && !passwordError && !confirmPasswordError) {
                        navController.navigate(Navigation.HOME.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors( Color(0xFFFF6F00))
            ) {
                Text("Send", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Back to Login",
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Navigation.LOGIN.name)
                    }
                    .padding(bottom = 38.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )

        }
    }

}