package uzb.smt.presenter.screens.usefull_tab

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR


@Composable
internal fun UseFullScreen(
    state: UseFullState,
    onAction: (UseFullIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.tab_usefull),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 26.sp,
                    color = Color(0xFF3A405A),
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.size(40.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "icon room",
                    tint = Color(0xFF3A405A),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(18.dp))
                Text(
                    text = stringResource(commonR.string.information),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF3A405A),
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFD9D9D9)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_learning),
                    contentDescription = "icon room",
                    tint = Color(0xFF3A405A),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(18.dp))
                Text(
                    text = stringResource(commonR.string.learing),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF3A405A),
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFD9D9D9))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "icon room",
                    tint = Color(0xFF3A405A),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(18.dp))
                Text(
                    text = stringResource(commonR.string.bmbba),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF3A405A),
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFD9D9D9))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_file_),
                    contentDescription = "icon room",
                    tint = Color(0xFF3A405A),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(18.dp))
                Text(
                    text = stringResource(commonR.string.olipiada),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF3A405A),
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
    }
}