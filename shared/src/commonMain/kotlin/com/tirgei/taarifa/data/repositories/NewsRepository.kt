package com.tirgei.taarifa.data.repositories

import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.domain.respositories.INewsRepository

class NewsRepository : INewsRepository {

    override suspend fun fetchNews(): List<NewsPost> {
        return listOf(
            NewsPost(
                source = NewsSource("the-verge", name = "The Verge"),
                author = "David Pierce",
                title = "A super-simple way to organize your internet",
                description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
                url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
                urlToImage = "https://cdn.vox-cdn.com/thumbor/GoOUX3JUoANyHVgoAg6W0i_-DdM=/0x0:3000x2000/1200x628/filters:focal(1500x1000:1501x1001)/cdn.vox-cdn.com/uploads/chorus_asset/file/24844605/Installer_Site_Post_001.jpg",
                publishedAt = "2023-09-03T12:00:00Z",
                content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
            ),
            NewsPost(
                source = NewsSource("the-verge", name = "The Verge"),
                author = "David Pierce",
                title = "A super-simple way to organize your internet",
                description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
                url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
                urlToImage = "https://cdn.vox-cdn.com/thumbor/GoOUX3JUoANyHVgoAg6W0i_-DdM=/0x0:3000x2000/1200x628/filters:focal(1500x1000:1501x1001)/cdn.vox-cdn.com/uploads/chorus_asset/file/24844605/Installer_Site_Post_001.jpg",
                publishedAt = "2023-09-03T12:00:00Z",
                content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
            ),
            NewsPost(
                source = NewsSource("the-verge", name = "The Verge"),
                author = "David Pierce",
                title = "A super-simple way to organize your internet",
                description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
                url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
                urlToImage = "https://cdn.vox-cdn.com/thumbor/GoOUX3JUoANyHVgoAg6W0i_-DdM=/0x0:3000x2000/1200x628/filters:focal(1500x1000:1501x1001)/cdn.vox-cdn.com/uploads/chorus_asset/file/24844605/Installer_Site_Post_001.jpg",
                publishedAt = "2023-09-03T12:00:00Z",
                content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
            ),
            NewsPost(
                source = NewsSource("the-verge", name = "The Verge"),
                author = "David Pierce",
                title = "A super-simple way to organize your internet",
                description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
                url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
                urlToImage = "https://cdn.vox-cdn.com/thumbor/GoOUX3JUoANyHVgoAg6W0i_-DdM=/0x0:3000x2000/1200x628/filters:focal(1500x1000:1501x1001)/cdn.vox-cdn.com/uploads/chorus_asset/file/24844605/Installer_Site_Post_001.jpg",
                publishedAt = "2023-09-03T12:00:00Z",
                content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
            ),
            NewsPost(
                source = NewsSource("the-verge", name = "The Verge"),
                author = "David Pierce",
                title = "A super-simple way to organize your internet",
                description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
                url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
                urlToImage = "https://cdn.vox-cdn.com/thumbor/GoOUX3JUoANyHVgoAg6W0i_-DdM=/0x0:3000x2000/1200x628/filters:focal(1500x1000:1501x1001)/cdn.vox-cdn.com/uploads/chorus_asset/file/24844605/Installer_Site_Post_001.jpg",
                publishedAt = "2023-09-03T12:00:00Z",
                content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
            ),
        )
    }
}