//
//  NewsDetailsViewModel.swift
//  iosApp
//
//  Created by Vincent Tirgei on 12/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

class NewsDetailsViewModel: ObservableObject {
    
    @Published private(set) var isLoading: Bool = false
    @Published private(set) var newsPost: NewsPost?
    
    private let repository = DIHelper().getNewsRepository()
    
    @MainActor
    func fetchNewsPost(id: String) async {
        do {
            isLoading = true
            let newsPost = try await asyncFunction(for: repository.fetchNewsPost(id: id))
            
            isLoading = false
            self.newsPost = newsPost
        } catch {
            print(error)
        }
    }
    
}
