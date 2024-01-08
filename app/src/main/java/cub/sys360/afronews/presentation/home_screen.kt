package cub.sys360.afronews.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.twotone.ThumbUp
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cub.sys360.afronews.core.navigation.navigationRoutes
import cub.sys360.afronews.core.shared_widgets.bookmarkButton
import cub.sys360.afronews.core.shared_widgets.sharedIconsImages
import cub.sys360.afronews.viewmodel.homeViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    //viewModel: homeViewModel = homeViewModel(),
    navController: NavHostController
) {


    val viewModel = homeViewModel()


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

//        val pagerState = rememberPagerState(
//            initialPage = 0,
//        )

        val pagerState = rememberPagerState(
            initialPage = 0,
            // initialPageOffsetFraction = 0f,
            pageCount = {
                viewModel.carousleData.size
            },

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


            // .padding(all = 20.dp),
            // modifier = Modifier.padding(all = 20.dp),
            HorizontalPager(
                modifier = Modifier,
                state = pagerState,
                pageSpacing = 0.dp,
                userScrollEnabled = true,
                reverseLayout = false,
                beyondBoundsPageCount = 0,
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .clickable {
                            navController.navigate(
                                navigationRoutes.detailsScreen.passRequiredArguments(
                                    title = viewModel.carousleData[it].title ,
                                    station =viewModel.carousleData[it].station ,
                                    desc= viewModel.carousleData[it].desc,
                                    imgUrl=viewModel.carousleData[it].imageUrl,
                                    category=viewModel.carousleData[it].category,
                                    channelLogo=viewModel.carousleData[it].channelLogo,
                                    timestamp=viewModel.carousleData[it].timestamp
                                )
                            )
                        }
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
                                text = viewModel.carousleData[it].title,
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


//            HorizontalPager(
//                pageCount = viewModel.carousleData.size,
//                state = pagerState
//                ) {
//                Card(
//                    elevation = CardDefaults.cardElevation(4.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(240.dp)
//                        .padding(end = 6.dp, start = 6.dp)
//                ) {
//
//                    Box() {
//                        Image(
//                            contentScale = ContentScale.FillBounds,
//                            painter = painterResource(id = viewModel.carousleData[it].imageUrl),
//                            contentDescription = "",
//                            modifier = Modifier.fillMaxSize()
//                        )
//
//
//                        Column(
//                            modifier = Modifier.align(alignment = Alignment.BottomCenter)
//                        ) {
//
//
//                            Row(
//                                modifier = Modifier.padding(start = 12.dp)
//                            ) {
//                                Image(
//                                    painter = painterResource(id = viewModel.carousleData[it].channelLogo),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .size(30.dp)
//                                        .shadow(
//                                            elevation = 4.dp,
//                                            shape = CircleShape
//                                        )
//                                )
//
//                                Spacer(modifier = Modifier.size(5.dp))
//
//                                Text(
//                                    text = viewModel.carousleData[it].station,
//                                    // modifier = Modifier.padding(all = 20.dp),
//                                    style = MaterialTheme.typography.headlineSmall.copy(
//                                        color = Color.White
//                                    ),
//
//
//                                    )
//
//                            }
//
//
//                            Text(
//                                text = viewModel.carousleData[it].title,
//                                modifier = Modifier
//                                    .align(alignment = Alignment.Start)
//                                    .padding(start = 10.dp, bottom = 8.dp, top = 4.dp),
//                                // .padding(all = 20.dp),
//                                style = MaterialTheme.typography.headlineSmall.copy(
//                                    color = Color.White
//                                ),
//
//
//                                )
//                        }
//
//
//                    }
//                }
//            }


                Spacer(modifier = Modifier.height(12.dp))


                Row(
                    Modifier
                        .fillMaxWidth()
                        // .align(Alignment.BottomCenter)
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(viewModel.carousleData.size) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.Green else Color.LightGray
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp, end = 12.dp),


                    ) {
                    Text(
                        text = "Recommendation",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "Show more",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Green,
                            //fontSize = 16.sp
                        )
                    )
                }


                Spacer(modifier = Modifier.height(8.dp))





                LazyColumn {
                    items(viewModel.recommendedNews.size) {
                        Card(
                            modifier = Modifier
                                .clickable {

                                    navController.navigate(
                                        navigationRoutes.detailsScreen.passRequiredArguments(
                                            title = viewModel.recommendedNews[it].title ,
                                            station =viewModel.recommendedNews[it].station ,
                                            desc= viewModel.recommendedNews[it].desc,
                                            imgUrl=viewModel.recommendedNews[it].imageUrl,
                                            category=viewModel.recommendedNews[it].category,
                                            channelLogo=viewModel.recommendedNews[it].channelLogo,
                                            timestamp=viewModel.recommendedNews[it].timestamp
                                        )
                                    )
                                }
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(start = 3.dp, end = 3.dp, bottom = 5.dp)
                        ) {
                            Row {

                                //left
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth(0.5f)
                                        .fillMaxHeight(),
                                    color = Color.Green


                                ) {

                                    Image(
                                        painter = painterResource(id = viewModel.recommendedNews[it].imageUrl),
                                        contentDescription = "Images",
                                        modifier = Modifier.clip(RectangleShape),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }


                                //right
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(),
                                    // color = Color.Red,


                                ) {

                                    Column(
                                        modifier = Modifier.padding(4.dp),
                                        verticalArrangement = Arrangement.Top,
                                        //horizontalAlignment = Alignment.CenterHorizontally,
                                    ) {
                                        Text(
                                            text = viewModel.recommendedNews[it].title,
                                            maxLines = 2,
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = FontWeight.W700
                                            ),
                                            overflow = TextOverflow.Ellipsis
                                        )

                                        Spacer(modifier = Modifier.height(38.dp))

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Text(
                                                text = viewModel.recommendedNews[it].timestamp,
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    color = Color.LightGray,
                                                    fontWeight = FontWeight.W400
                                                )
                                            )


                                            bookmarkButton(icon = Icons.TwoTone.ThumbUp) {

                                            }
                                        }

                                    }


                                }

                            }
                        }
                    }
                }


            }
        }

    }