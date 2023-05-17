/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.sideproject.mercy.presentation.view.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.sideproject.mercy.R
import com.sideproject.mercy.presentation.theme.MercySkeletonTheme

enum class OnBoardingScreen(val route: String) {
  Start(route = "start"),
  END(route = "end")
}

@Composable
fun StartOnBoardingScreen(
  viewModel: OnBoardingViewModel = viewModel(),
  contents: String,
  onClickNextButton: () -> Unit,
) {
  val sampleData by viewModel.sampleData.collectAsState()
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp)
  ) {
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 120.dp),
      text = "OnBoarding",
      style = MaterialTheme.typography.headlineLarge,
      textAlign = TextAlign.Center
    )
    Text(
      text = contents,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
      textAlign = TextAlign.Center
    )
    AsyncImage(
      model = sampleData.data?.imageUrl,
      modifier = Modifier
        .padding(vertical = 10.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp)),
      placeholder = painterResource(id = R.drawable.images_mode),
      contentDescription = null,
    )
    Button(
      onClick = { onClickNextButton() },
      modifier = Modifier
        .fillMaxWidth()
        .background(
          color = MaterialTheme.colorScheme.primary,
          shape = RoundedCornerShape(12.dp)
        )
        .padding(vertical = 4.dp)
    ) {
      Text(text = "Next")
    }
  }
}

@Composable
fun EndOnBoardingScreen(
  viewModel: OnBoardingViewModel = viewModel(),
  contents: String) {

  val sampleData by viewModel.sampleData.collectAsState()

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp)
  ) {
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 120.dp),
      text = "end",
      style = MaterialTheme.typography.headlineLarge,
      textAlign = TextAlign.Center
    )
    Text(
      text = contents,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
      textAlign = TextAlign.Center
    )
    AsyncImage(
      model = sampleData.data?.imageUrl,
      modifier = Modifier
        .padding(vertical = 10.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp)),
      placeholder = painterResource(id = R.drawable.images_mode),
      contentDescription = null,
    )
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .background(
          color = MaterialTheme.colorScheme.primary,
          shape = RoundedCornerShape(12.dp)
        )
        .padding(vertical = 4.dp)
    ) {
      Text(text = "Next")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MercySkeletonTheme {
    StartOnBoardingScreen(
      contents = "I'm not superstitious, but I am a little stitious",
      onClickNextButton = {}
    )
  }
}


