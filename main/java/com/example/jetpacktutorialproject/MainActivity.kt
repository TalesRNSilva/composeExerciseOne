package com.example.jetpacktutorialproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacktutorialproject.ui.theme.JetPackTutorialProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackTutorialProjectTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Tutorial(
//                        title = stringResource(R.string.title),
//                        firstText = stringResource(R.string.firstTutorial),
//                        secondText = stringResource(R.string.secondTutorial),
//                        image = painterResource(R.drawable.bg_compose_background)
//                    )
//                }

//                TaskCompleteMessage(image = painterResource(R.drawable.ic_task_completed),
//                    taskComplete = stringResource(R.string.taskComplete),
//                    goodJob = stringResource(R.string.goodJob),
//                    modifier = Modifier
//                )
                Surface(modifier = Modifier.fillMaxSize()) {
                    Quadrantes(
                        title1 = stringResource(R.string.title1),
                        string1 = stringResource(R.string.string1),
                        title2 = stringResource(R.string.title2),
                        string2 = stringResource(R.string.string2),
                        title3 = stringResource(R.string.title3),
                        string3 = stringResource(R.string.string3),
                        title4 = stringResource(R.string.title4),
                        string4 = stringResource(R.string.string4)
                    )
                }

            }
        }
    }
}



@Composable
fun Tutorial(title:String,
             firstText:String,
             secondText:String,
             image: Painter,
             modifier:Modifier = Modifier) {

    Box(modifier = modifier){
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(text = title,
                fontSize = 24.sp,
                modifier = modifier.padding(16.dp))

            Text(text = firstText,
                textAlign = TextAlign.Justify,
                modifier = modifier.padding(start = 16.dp, end = 16.dp))

            Text(text = secondText,
                textAlign = TextAlign.Justify,
                modifier = modifier.padding(16.dp))
        }
    }
}

@Composable
fun TaskCompleteMessage(image:Painter, taskComplete:String, goodJob:String, modifier:Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = taskComplete,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = goodJob,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Quadrantes(
    title1: String, string1: String,
    title2: String, string2: String,
    title3: String, string3: String,
    title4: String, string4: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()
            .weight(1f)) {
            Quadrante(
                title1,
                string1,
                Color(0xFFEADDFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            Quadrante(
                title2,
                string2,
                Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
        // Row 2
        Row(modifier = Modifier.fillMaxSize()
            .weight(1f)) {
            Quadrante(
                title3,
                string3,
                Color(0xFFB69DF8),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            Quadrante(
                title4,
                string4,
                Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
    }
}
@Composable
fun Quadrante(title:String, text:String, color:Color, modifier:Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = text, textAlign = TextAlign.Justify, fontSize = 16.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantesPreview() {
    JetPackTutorialProjectTheme {
//        Quadrante(title = stringResource(R.string.title1), text = stringResource(R.string.string1), color = Color(0xFFEADDFF))
        Quadrantes(
            title1 = stringResource(R.string.title1), string1 = stringResource(R.string.string1),
            title2 = stringResource(R.string.title2), string2 = stringResource(R.string.string2),
            title3 = stringResource(R.string.title3), string3 = stringResource(R.string.string3),
            title4 = stringResource(R.string.title4), string4 = stringResource(R.string.string4)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TutorialPreview() {
    JetPackTutorialProjectTheme {
        Tutorial(title = stringResource(R.string.title),
            firstText = stringResource(R.string.firstTutorial),
            secondText = stringResource(R.string.secondTutorial),
            image = painterResource(R.drawable.bg_compose_background)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskCompletePreview() {
    JetPackTutorialProjectTheme {
        TaskCompleteMessage(image = painterResource(R.drawable.ic_task_completed),
            taskComplete = stringResource(R.string.taskComplete),
            goodJob = stringResource(R.string.goodJob),
            modifier = Modifier
        )
    }
}


