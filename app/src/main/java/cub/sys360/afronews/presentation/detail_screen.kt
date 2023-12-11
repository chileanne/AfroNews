package cub.sys360.afronews.presentation

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import cub.sys360.afronews.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(){

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
               colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                   containerColor = MaterialTheme.colorScheme.primaryContainer,
                   titleContentColor = MaterialTheme.colorScheme.primary,
               ),
                title = {
                    Text(text = "Sports")
            },

                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO*/ }) {

                 Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back Arrow")

                    }
                },


                actions = {
                    IconButton(
                        onClick = { /*TODO*/ },) {

                        Icon(imageVector = Icons.Filled.Share,contentDescription = "Share")
                    }
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
                   painter = painterResource(id = R.drawable.dj),
                   contentDescription =""
               )
           }

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            
            
            Text(text = "Djokovic Dominates the Tennis Court: A masterclass in Tennise Brilliance")

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
                Text(text = "1 hour ago")
            }



            Spacer(
                modifier = Modifier.height(8.dp)
            )



            Text(text = "By Jehnson Wilson")

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan enim eget massa volutpat tristique. Cras luctus ultricies dolor, ut efficitur risus blandit in. Cras ac pellentesque odio. Sed dignissim eros ut elit viverra, vitae maximus neque tempor. In pellentesque mollis dolor ut lacinia. Suspendisse sollicitudin velit ac arcu consequat iaculis. Etiam arcu lacus, faucibus ac arcu eu, auctor efficitur massa. Vivamus a nibh erat. Donec vitae nibh sed ligula pharetra egestas in consequat nulla. Quisque ullamcorper sed purus sagittis ultricies. Ut quis metus ex. Praesent ante tellus, finibus at lobortis et, elementum vitae nisl. Maecenas maximus turpis at mi congue auctor. Vivamus at diam odio.\n" +
                    "\n" +
                    "Ut orci ante, dignissim quis mollis quis, luctus non arcu. Cras tristique nibh dolor, eu volutpat lorem pellentesque ac. Phasellus non urna fermentum, malesuada velit sed, blandit quam. Donec facilisis nisi quis egestas ornare. Integer ut dictum nunc. Suspendisse hendrerit sit amet enim rhoncus rutrum. Fusce malesuada quis mi vehicula mollis. Aenean vel vestibulum tortor. Etiam eu condimentum metus, vel sollicitudin libero. Interdum et malesuada fames ac ante ipsum primis in faucibus.",

                )




        }
    }
}