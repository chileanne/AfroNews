package cub.sys360.afronews.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cub.sys360.afronews.R


//defining font
val interFamily = FontFamily(
    Font(R.font.inter_black, FontWeight.W900),
    Font(R.font.inter_bold, FontWeight.W700),
    Font(R.font.inter_extrabold, FontWeight.W800,),
    Font(R.font.inter_regular, FontWeight.W400),
    Font(R.font.inter_extralight, FontWeight.W200),
    Font(R.font.inter_medium, FontWeight.W500),
    Font(R.font.inter_thin, FontWeight.W100)
)

// Set of Material typography styles to start with
val Typography = Typography(

    headlineSmall = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),


    bodyLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),



    bodyMedium = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),



    bodySmall = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W200,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),











    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)