package cub.sys360.afronews.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import cub.sys360.afronews.R
import cub.sys360.afronews.core.shared_widgets.sharedIconsImages
import cub.sys360.afronews.viewmodel.homeViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: homeViewModel = homeViewModel()
) {


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "AfroNews",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },

                actions = {
                    sharedIconsImages(
                        icon = Icons.Filled.Search,
                        onclick = {}
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    sharedIconsImages(
                        icon = Icons.Filled.Notifications,
                        onclick = {}
                    )
                }

            )
        }
    ) {

        val pagerState = rememberPagerState(
            initialPage = 0,
        )




        /**i dont understand yet**/
        LaunchedEffect(pagerState) {
            // Collect from the a snapshotFlow reading the currentPage
            snapshotFlow { pagerState.currentPage }.collect { page ->
                // Do something with each page change, for example:
                // viewModel.sendPageSelectedEvent(page)
                Log.d("Page change", "Page changed to $page")
            }
        }

        Column(
            modifier = Modifier.padding(it)
        ) {


            HorizontalPager(
                pageCount = viewModel.carousleData.size,
                state = pagerState
                ) {
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(end = 6.dp, start = 6.dp)
                ) {

                    Box() {
                        Image(
                            contentScale = ContentScale.FillBounds,
                            painter = painterResource(id = viewModel.carousleData[it].imageUrl),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )


                        Column(
                            modifier = Modifier.align(alignment = Alignment.BottomCenter)
                        ) {


                            Row(
                                modifier = Modifier.padding(start = 12.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = viewModel.carousleData[it].channelLogo),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .shadow(
                                            elevation = 4.dp,
                                            shape = CircleShape
                                        )
                                )

                                Spacer(modifier = Modifier.size(5.dp))

                                Text(
                                    text = viewModel.carousleData[it].station,
                                    // modifier = Modifier.padding(all = 20.dp),
                                    style = MaterialTheme.typography.headlineSmall.copy(
                                        color = Color.White
                                    ),


                                    )

                            }


                            Text(
                                text = viewModel.carousleData[it].desc,
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .padding(start = 10.dp, bottom = 8.dp, top = 4.dp),
                                // .padding(all = 20.dp),
                                style = MaterialTheme.typography.headlineSmall.copy(
                                    color = Color.White
                                ),


                                )
                        }


                    }
                }
            }


            Spacer(modifier = Modifier.height(12.dp))


            Row(
                Modifier
                    .fillMaxWidth()
                    // .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(viewModel.carousleData.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.Green else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(RectangleShape)
                            .background(color)
                            .width(40.dp)
                            .height(4.dp)
                            //.size(30.dp)
                    )
                }

            }
            
            
            
            
            /** Recommended news**/
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp, end = 3.dp),
              horizontalArrangement = Arrangement.SpaceBetween
                
            ){
                Text(text = "Recommendation")
                Text(text = "Show more")
            }
            
            
            
            LazyColumn{
                items(viewModel.recommendedNews.size) {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .height(180.dp)
                            .padding(start = 3.dp, end = 3.dp, bottom = 5.dp)
                    ) {
                        Row {

                            //left
                            Surface(
                                modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight()
                                    ,
                                color = Color.Green


                            ) {

                            }


                            //right
                            Surface(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                color = Color.Red,


                            ) {

                            }

                        }
                    }
                }
            }
            
            
            
            


        }
    }

}