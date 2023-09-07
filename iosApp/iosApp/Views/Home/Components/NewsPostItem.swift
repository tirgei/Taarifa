//
//  NewsPostItem.swift
//  iosApp
//
//  Created by Vincent Tirgei on 07/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsPostItem: View {
    var newsPost: NewsPost
    
    var body: some View {
        Text(newsPost.title)
    }
}

struct NewsPostItem_Previews: PreviewProvider {
    static var previews: some View {
        let newsPost = NewsPost(
            source: NewsSource(id: "NTV", name: "NTV"),
            author: "John Doe",
            title: "Test News",
            description: "Test News",
            url: "https://example.com",
            urlToImage: "http://example.cin",
            publishedAt: "24 Sep 2023",
            content: "Test Content"
        )
        NewsPostItem(newsPost: newsPost)
    }
}
