import SwiftUI
import shared

struct HomeView: View {
    
    @StateObject var viewModel = HomeViewModel()

	var body: some View {
        NavigationView {
            ZStack() {
                if (viewModel.isLoading) {
                    ProgressView()
                } else {
                    VStack {
                        CategoriesList()
                            .environmentObject(viewModel)
                        
                        NewsList()
                            .environmentObject(viewModel)
                    }
                }
            }
            .navigationTitle("Taarifa")
            .toolbar {
                Image(systemName: "magnifyingglass")
            }
        }
        .task {
            await viewModel.fetchNewsCategories()
            await viewModel.fetchNewsPosts()
        }
	}
}

struct CategoriesList: View {
    
    @EnvironmentObject var viewModel: HomeViewModel
    @State var selectedCategory = 1
    
    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            HStack {
                ForEach(
                    Array(viewModel.newsCategories.enumerated()),
                    id: \.element
                ) { index, category in
                    NewsCategoryItem(title: category, isSelected: selectedCategory == index) {
                        selectedCategory = index
                    }
                }
            }
            .padding(.horizontal, 10)
        }
    }
}

struct NewsList: View {
    
    @EnvironmentObject var viewModel: HomeViewModel
    
    var body: some View {
        ScrollView {
            LazyVStack(alignment: .leading, spacing: 0) {
                ForEach(viewModel.newsPosts, id: \.self) { news in
                    NavigationLink(destination: NewsDetailsView(newsPostId: news.title)) {
                        NewsPostItem(newsPost: news)
                            .padding()
                    }
                    .buttonStyle(PlainButtonStyle())
                }
            }
        }
    }
}


struct HomeView_Previews: PreviewProvider {
	static var previews: some View {
		Text("Preview")
	}
}
