package uzb.smt.presenter.screens.subject_tab.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.R
import uzb.smt.domen.model.SubjectData
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun FavouriteSubjectItem(
    modifier: Modifier = Modifier,
    subjectData: SubjectData,
    isLeft: Boolean = false
) {
    Card(
        modifier = modifier.height(177.dp),
        shape = RoundedCornerShape(22.dp),
        onClick = {}
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(subjectData.logo),
                contentDescription = "img subject",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = if (subjectData.isNight) Color.Black.copy(alpha = 0.2f) else Color.White.copy(alpha = 0.2f)
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = if (isLeft) Alignment.Start else Alignment.End
            ) {
                Row(
                    modifier = Modifier
                        .clickable(
                            onClick = {},
                            indication = ripple(),
                            interactionSource = remember { MutableInteractionSource() }
                        )
                        .background(
                            color = if (subjectData.isNight) Color.White.copy(0.8f) else Color.White.copy(0.93f),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 11.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.favourite),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.W400,
                            fontFamily = Montserrat
                        )
                    )
                    Spacer(Modifier.width(2.dp))
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(uzb.smt.presenter.R.drawable.ic_heart),
                        contentDescription = "bookmark",
                        tint = Color(0xFFFF7878)
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 8.dp),
                    text = subjectData.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 22.sp,
                        color = if (subjectData.isNight) Color(0xFFFFFFFF) else Color(0xFF000000),
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
    }
}