package cub.sys360.afronews.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cub.sys360.afronews.R
import cub.sys360.afronews.core.shared_widgets.sharedIconsImages

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(
    navController: NavHostController,
    title: String?,
    station: String?,
    desc: String?,
    imgurl: Int?,
    category: String?,
    channelLogo: String?,
    timestamp: String?
) {

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
               colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                  // containerColor = MaterialTheme.colorScheme.primaryContainer,
                   //titleContentColor = MaterialTheme.colorScheme.primary,
               ),
                title = {
                    Text(
                        text = "Sports",
                        style =MaterialTheme.typography.headlineSmall )
            },

                navigationIcon = {

                    sharedIconsImages(
                        icon  = Icons.Filled.ArrowBack,
                        onclick = {
                            navController.popBackStack()
                        }
                    )


                },


                actions = {
                    sharedIconsImages(
                        icon  =  Icons.Filled.Share,
                        onclick = {}
                    )
                }



                )
        }
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(it)
                .padding(8.dp)

              //  .padding(all = it.dp)
        ) {


           Surface (
               shape = MaterialTheme.shapes.small,
               shadowElevation = 4.dp,
               color = Color.Yellow,
               modifier = Modifier
                   .fillMaxWidth()
                  // .padding(6.dp)
                   .height(280.dp)

           ){
               Image(

                     //  .fillMaxSize(),
                  contentScale = ContentScale.FillBounds,
                   painter = painterResource(id = imgurl!!),
                   contentDescription =""
               )
           }

            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = title!!,
                style = MaterialTheme.typography.bodyLarge)

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.schedule),
                    contentDescription ="" )
                Spacer(
                    modifier = Modifier.width(8.dp)
                )
                Text(text = timestamp!!,
                    style = MaterialTheme.typography.bodySmall)
            }



            Spacer(
                modifier = Modifier.height(8.dp)
            )



            Text(text = "By ${station!!}",
                style= MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500
                ))

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            
            Text(text = desc!! ,
                style = MaterialTheme.typography.bodyMedium
                )




        }
    }
}