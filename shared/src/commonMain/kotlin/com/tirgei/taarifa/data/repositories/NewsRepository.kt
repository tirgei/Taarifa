package com.tirgei.taarifa.data.repositories

import com.tirgei.taarifa.core.Dispatcher
import com.tirgei.taarifa.data.network.ApiService
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.domain.respositories.INewsRepository
import kotlinx.coroutines.withContext

class NewsRepository(
    private val apiService: ApiService,
    private val dispatcher: Dispatcher
) : INewsRepository {

    override suspend fun fetchNews(): List<NewsPost> = withContext(dispatcher.io) {
        newsPosts
    }

    override suspend fun fetchNewsPost(id: String): NewsPost = withContext(dispatcher.io) {
        newsPosts.first { it.title == id }
    }

    private val newsPosts = listOf(
        NewsPost(
            source = NewsSource("the-verge", name = "The Verge"),
            author = "David Pierce",
            title = "A super-simple way to organize your internet",
            description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
            url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/230904105448-danelo-cavalcante-mug-shot.jpg?c=16x9&q=w_800,c_fill",
            publishedAt = "2023-09-03T12:00:00Z",
            content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
        ),
        NewsPost(
            source = NewsSource("the-verge", name = "The Verge"),
            author = "David Pierce",
            title = "A super-simple way to organize your internet",
            description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
            url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/230904105448-danelo-cavalcante-mug-shot.jpg?c=16x9&q=w_800,c_fill",
            publishedAt = "2023-09-03T12:00:00Z",
            content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
        ),
        NewsPost(
            source = NewsSource("the-verge", name = "The Verge"),
            author = "David Pierce",
            title = "A super-simple way to organize your internet",
            description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
            url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/230904105448-danelo-cavalcante-mug-shot.jpg?c=16x9&q=w_800,c_fill",
            publishedAt = "2023-09-03T12:00:00Z",
            content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
        ),
        NewsPost(
            source = NewsSource("the-verge", name = "The Verge"),
            author = "David Pierce",
            title = "A super-simple way to organize your internet",
            description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
            url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/230904105448-danelo-cavalcante-mug-shot.jpg?c=16x9&q=w_800,c_fill",
            publishedAt = "2023-09-03T12:00:00Z",
            content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
        ),
        NewsPost(
            source = NewsSource("the-verge", name = "The Verge"),
            author = "David Pierce",
            title = "A super-simple way to organize your internet",
            description = "Starfield’s launch, a great camera app for the iPhone, the Quibi story, One Piece of Netflix, and more in this week’s Installer.",
            url = "https://www.theverge.com/2023/9/3/23855448/bookmarking-apps-starfield-retro-games-quibi-history-installer-newsletter",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/230904105448-danelo-cavalcante-mug-shot.jpg?c=16x9&q=w_800,c_fill",
            publishedAt = "2023-09-03T12:00:00Z",
            content = "A super-simple way to organize your internet\\r\\nA super-simple way to organize your internet\\r\\n / Plus, in this weeks Installer: Starfield is here, the Quibi story, and some great retro games.\\r\\nByDavid"
        ),
    )
}