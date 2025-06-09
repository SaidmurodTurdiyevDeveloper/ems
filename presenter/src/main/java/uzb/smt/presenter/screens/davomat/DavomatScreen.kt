package uzb.smt.presenter.screens.davomat

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.theme.LightGreenSecond
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR


@Composable
fun DavomatScreen(
    state: DavomatState,
    onAction: (DavomatIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    Column(modifier = Modifier.fillMaxSize()) {

    }
}

@Composable
fun SuccessDavomat(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = LightGreenSecond,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White.copy(0.2f)
            )
    ) {
        Column(
            modifier = Modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(commonR.string.respect),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            val text= buildAnnotatedString {
                append(stringResource(commonR.string.respect_lyceum))
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W700
                    )
                ) {
                    append(
                        stringResource(commonR.string.acedemic_lyceum_mamuryat)
                    )
                }
            }
            Text(
                text =text ,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
        }
    }
}