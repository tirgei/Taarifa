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
        HStack(alignment: .center, spacing: 10) {
            AsyncImage(
                url: URL(string: newsPost.urlToImage),
                content : { image in
                    image.resizable()
                        .aspectRatio(contentMode: .fill)
                        .frame(width: 100, height: 80)
                        .clipped()
                },
                placeholder: {
                    ProgressView()
                        .frame(width: 100, height: 80)
                }
            )
            .cornerRadius(10)
                        
            VStack(alignment: .leading, spacing: 5) {
                Text(newsPost.title)
                    .lineLimit(2)
                    .font(.headline)
                
                Text(newsPost.publishedAt)
                    .font(.caption)
                    .foregroundColor(.gray)
                
            }
        }
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
