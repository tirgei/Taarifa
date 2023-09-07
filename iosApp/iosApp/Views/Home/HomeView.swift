import SwiftUI
import shared

struct HomeView: View {
    
    @StateObject var viewModel = HomeViewModel()

	var body: some View {
        NavigationView {
            VStack {
                ZStack(alignment: .center) {
                    if (viewModel.isLoading) {
                        ProgressView()
                    } else {
                        VStack {
                            CategoriesList()
                                .environmentObject(viewModel)
                        }
                    }
                }
            }
            .navigationTitle("Taarifa")
            .toolbar {
                Image(systemName: "search")
                    .padding()
            }
        }
        .task {
            await viewModel.fetchNewsCategories()
//            await viewModel.fetchNewsPosts()
        }
	}
}

struct CategoriesList: View {
    
    @EnvironmentObject var viewModel: HomeViewModel
    @State var selectedCategory = 1
    
    var body: some View {
        ScrollView {
            HStack(alignment: .center) {
                ForEach(
                    Array(viewModel.newsCategories.enumerated()),
                    id: \.element
                ) { index, category in
                    NewsCategoryItem(title: category, isSelected: selectedCategory == index) {
                        selectedCategory = index
                    }
                }
            }
        }
    }
}

struct NewsList: View {
    
    @EnvironmentObject var viewModel: HomeViewModel
    
    var body: some View {
        ScrollView {
            HStack {
                ForEach(viewModel.newsPosts, id: \.publishedAt) { news in
                    NewsPostItem(newsPost: news)
                        .padding()
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
