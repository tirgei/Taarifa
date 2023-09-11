//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Vincent Tirgei on 07/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync


class HomeViewModel: ObservableObject {
    @Published private(set) var newsPosts: [NewsPost] = []
    @Published private(set) var newsCategories: [String] = []
    @Published private(set) var isLoading = false
    
    private let newsRepository: NewsRepository = DIHelper().getNewsRepository()
    
    @MainActor
    func fetchNewsCategories() async {
        do {
            let categories = try await asyncFunction(for: newsRepository.fetchNewsCategories())
            newsCategories = categories
        } catch {
            print(error)
        }
    }
    
    @MainActor
    func fetchNewsPosts() async {
        do {
            isLoading = true
            let news = try await asyncFunction(for: newsRepository.fetchNews())
            
            isLoading = false
            newsPosts = news
        } catch {
            isLoading = false
            print(error)
        }
    }
    
}
