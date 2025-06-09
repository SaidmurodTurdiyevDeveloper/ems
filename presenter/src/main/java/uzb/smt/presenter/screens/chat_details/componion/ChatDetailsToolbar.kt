package uzb.smt.presenter.screens.chat_details.componion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.DarkPurple
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple

@Composable
internal fun ChatDetailsToolbar(
    modifier: Modifier = Modifier,
    name: String,
    back: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_avatar),
            contentDescription = "avatar",
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 22.sp,
                color = DarkPurple,
                fontWeight = FontWeight.W600,
                fontFamily = Montserrat
            )
        )
        Spacer(Modifier.weight(1f))
        IconButton(
            modifier = Modifier.size(30.dp),
            onClick = back
        ) {
            Icon(
                modifier = Modifier.size(22.dp),
                imageVector = Icons.Default.Close,
                tint = Purple,
                contentDescription = "close",
            )
        }
    }
}

@Preview
@Composable
private fun ChatDetailsToolbarPrev() {
    ChatDetailsToolbar(
        name = "Chat name",
        back = {}
    )
}