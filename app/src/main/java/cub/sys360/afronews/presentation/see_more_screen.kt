package cub.sys360.afronews.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.twotone.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeemoreScreen(navController: NavHostController) {

    val viewModel = homeViewModel()


    Scaffold (

        topBar = {
            Surface(
             shadowElevation = 3.dp
            ) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Recommended News",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    },

                    navigationIcon = {

                        sharedIconsImages(
                            icon  = Icons.Filled.ArrowBack,
                            onclick = {
                                navController.popBackStack()
                            }
                        )


                    },


                    )
            }
        }
    ) {

        LazyColumn(modifier = Modifier.padding(it)){
            
            item { Spacer(modifier = Modifier.height(10.dp)) }

            items(viewModel.recommendedNews.size) {
                Card(
                    modifier = Modifier
                        .clickable {

                            navController.navigate(
                                navigationRoutes.detailsScreen.passRequiredArguments(
                                    title = viewModel.recommendedNews[it].title,
                                    station = viewModel.recommendedNews[it].station,
                                    desc = viewModel.recommendedNews[it].desc,
                                    imgUrl = viewModel.recommendedNews[it].imageUrl,
                                    category = viewModel.recommendedNews[it].category,
                                    channelLogo = viewModel.recommendedNews[it].channelLogo,
                                    timestamp = viewModel.recommendedNews[it].timestamp
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