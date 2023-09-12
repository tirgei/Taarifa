//
//  NewsDetailsView.swift
//  iosApp
//
//  Created by Vincent Tirgei on 12/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsDetailsView: View {
    var newsPostId: String
    @StateObject var viewModel = NewsDetailsViewModel()
    
    var body: some View {
        ZStack(alignment: .top) {
            if (viewModel.isLoading) {
                ProgressView()
            }

            if let newsPost = viewModel.newsPost {
                NewsDetails(newsPost: newsPost)
            }
        }
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                HStack(spacing: 16) {
                    Image(systemName: "heart")
                    
                    Image(systemName: "square.and.arrow.up")
                }
            }
        }
        .task {
            await viewModel.fetchNewsPost(id: newsPostId)
        }
    }
}

struct NewsDetails: View {
    var newsPost: NewsPost
    
    var body: some View {
        GeometryReader { geo in
            ScrollView(.vertical) {
                VStack {
                    AsyncImage(
                        url: URL(string: newsPost.urlToImage),
                        content: {  image in
                            image.resizable()
                                .scaledToFill()
                                .frame(width: geo.size.width, height: 300)
                                .clipped()
                            
                        },
                        placeholder: {
                            ProgressView()
                        }
                    )
                    .frame(width: geo.size.width, height: 300)
                    
                    VStack (alignment: .leading) {
                        AuthorDetails(author: newsPost.author)
                        
                        Text(newsPost.title)
                            .font(.title2)
                            .padding(.vertical, 5)
                        
                        Text(newsPost.publishedAt)
                            .font(.caption)
                        
                        Spacer()
                        
                        Text(newsPost.content)
                            .font(.body)
                            .padding(.vertical, 10)
                    }
                    .padding(10)
                }
            }
        }
    }
}

struct AuthorDetails: View {
    var author: String
    
    var body: some View {
        HStack(alignment: .center) {
            Image(systemName: "person.fill")
                .resizable()
                .scaledToFit()
                .padding()
                .frame(width: 60, height: 60)
                .cornerRadius(10)
            
            VStack(alignment: .leading) {
                Text("Article By")
                    .font(.caption)
                
                Text(author)
                    .lineLimit(2)
                    .font(.body)
            }
        }
    }
}

struct NewsDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        let newsPost = NewsPost(
            source: NewsSource(id: "TMZ", name: "TMZ"),
            author: "John Doe",
            title: "Test News",
            description: "Test News",
            url: "https://example.com",
            urlToImage: "https://www.livemint.com/lm-img/img/2023/09/12/600x338/Arizona-Taiwanese-Microchip-Company-0_1692081764638_1694508798878.jpg",
            publishedAt: "12 Sep 2023",
            content: "News Details Content"
        )
        
        NewsDetails(newsPost: newsPost)
    }
}
