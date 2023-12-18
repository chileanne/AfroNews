package cub.sys360.afronews.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
){



    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "AfroNews",
                        style = MaterialTheme.typography.headlineSmall )
                },

                actions = {
                    sharedIconsImages(
                        icon  =  Icons.Filled.Search,
                        onclick = {}
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    sharedIconsImages(
                        icon  =  Icons.Filled.Notifications,
                        onclick = {}
                    )
                }

            )
        }
    ) {

        val pagerState = rememberPagerState(
          initialPage = 0
        )

        Column(
            modifier = Modifier.padding(it)
        ) {



            
            
            HorizontalPager(pageCount = viewModel.carousleData.size) {
                Card (
                  elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(end = 6.dp, start = 6.dp)
                ){

                    Box () {
                        Image(
                            contentScale = ContentScale.FillBounds,
                            painter = painterResource(id = R.drawable.dj),
                            contentDescription ="",
                            modifier=Modifier.fillMaxSize()
                        )


                        Column (
                            modifier = Modifier.align(alignment = Alignment.BottomCenter)
                        ){



                           Text(
                                text = viewModel.carousleData[it].desc,
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .padding(all = 20.dp),
                                style = MaterialTheme.typography.headlineSmall.copy(
                                    color = Color.White
                                ),


                            )
                        }


                    }
                }
            }

            


        }
    }
}