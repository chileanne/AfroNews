package cub.sys360.afronews.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cub.sys360.afronews.R
import cub.sys360.afronews.core.models.NewsModel

class homeViewModel : ViewModel() {

    //var carousleData by mutableStateOf<List<NewsModel>>(emptyList())

    var carousleData = mutableListOf<NewsModel>();
    var recommendedNews = mutableListOf<NewsModel>()

    init {

       carousleData.add(NewsModel(
           station = "CNN",
           desc = "Mbappe Stellar performance Takes football to new heights",
           imageUrl = R.drawable.mbappe,
           category = "Sport",
           channelLogo = R.drawable.cnn,


       ))

        carousleData.add(NewsModel(
            station = "Channels Tv",
            desc = "Isreal-Gaza war still rages an urgent call for peace is needed",
            imageUrl =R.drawable.isreal,
            category = "World News",
            channelLogo = R.drawable.channels

        ))


        carousleData.add(NewsModel(
            station = "BBC",
            desc = "Putin visit UAE and Saudi Arabia on a rare one day visit",
            imageUrl = R.drawable.putin,
            category = "World News",
            channelLogo = R.drawable.bbc

        ))


        carousleData.add(NewsModel(
            station = "AIT",
            desc = "Ukraine tells washignton not to stop aid package",
            imageUrl = R.drawable.ukraine,
            category = "War in Ukraine",
            channelLogo = R.drawable.ait

        ))



        /**Recommend news list**/


        //sports
        recommendedNews.add(NewsModel(
            station = "India record shortest ever Test win to level series in South Africa",
            desc = "India’s cricket captain Rohit Sharma has lashed out at critics of Indian pitches after his side recorded the quickest ever win in a Test match by beating South Africa by seven wickets in four-and-a-half sessions of the five-day match.\n" +
                    "\n" +
                    "India’s win over hosts South Africa on a seaming surface with variable bounce at Newlands saw them end the two-match series in a 1-1 draw following the hosts’ win in the first Test.",
            imageUrl = R.drawable.sport1,
            category = "Sport",
            channelLogo = 1

        ))


        recommendedNews.add(NewsModel(
            station = "Palmer nominated for Premier League prize",
            desc = "Cole Palmer has been included in a list of eight nominees vying to be named as the Premier League’s Player of the Month for December.",
            imageUrl = R.drawable.sport2,
            category = "Sport",
            channelLogo = 1

        ))


        recommendedNews.add(NewsModel(
            station = "Matos heads to Huddersfield",
            desc = "The 19-year-old joined the Blues from Norwich City in the summer and quickly established himself in Mauricio Pochettino’s first-team squad.\n" +
                    "\n" +
                    "Matos, who is capable of playing in midfield or attack, made his Chelsea debut in our victory over Fulham in October and a second appearance came in the Carabao Cup win against Blackburn Rovers.\n" +
                    "\n" +
                    "He will now continue his development at Huddersfield, who sit 21st in the Championship.\n" +
                    "\n" +
                    "Good luck, Alex!",
            imageUrl = R.drawable.sport3,
            category = "Sport",
            channelLogo = 1

        ))


        //tech

        recommendedNews.add(NewsModel(
            station = "This startup is bringing a ‘voice frequency absorber’ to CES 2024",
            desc = "CES has always been the place for weird, out-there gadgets to make their debuts, and this year’s show is no exception.\n" +
                    "\n" +
                    "Skyted, a Toulouse, France-based startup founded by former Airbus VP Stéphane Hersen and acoustical engineer Frank Simon, is bringing what look like a pair of human muzzles to CES 2024. Called the “Mobility Privacy Mask” and “Hybrid Silent Mask,” the face-worn accoutrements are designed to “absorb voice frequencies” in noisy environments like plains, trains and rideshares, Hersen says.",
            imageUrl = R.drawable.tech1,
            category = "Technology",
            channelLogo = 1

        ))


        recommendedNews.add(NewsModel(
            station = "For just \$139, this startup turns your iPhone into a BlackBerry-era relic",
            desc = "Clicks Technology is today unveiling the Clicks creator keyboard for the iPhone. It’s less “the future” than an unpleasant glance back to a world we thought we had left behind, in a nostalgia-tinged flashback to the days of BlackBerry and Nokia, where pressing physical buttons was the pinnacle of mobile communication.",
            imageUrl = R.drawable.tech2,
            category = "Technology",
            channelLogo = 1

        ))


        recommendedNews.add(NewsModel(
            station = "AI-powered search engine Perplexity AI, now valued at \$520M, raises \$73.6M",
            desc = "As search engine incumbents — namely Google — amp up their platforms with GenAI tech, startups are looking to reinvent AI-powered search from the ground up. It might seem like a Sisyphean task, going up against competitors with billions upon billions of users. But this new breed of search upstarts believes it can carve out a niche, however small, by delivering a superior experience.",
            imageUrl = R.drawable.tech3,
            category = "Technology",
            channelLogo = 1

        ))






    }
}