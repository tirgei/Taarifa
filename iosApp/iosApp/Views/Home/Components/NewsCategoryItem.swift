//
//  NewsCategoryItem.swift
//  iosApp
//
//  Created by Vincent Tirgei on 07/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NewsCategoryItem: View {
    var title: String
    var isSelected: Bool
    var onSelect: () -> ()
    
    var body: some View {
        Button {
            self.onSelect()
        } label: {
            VStack(alignment: .center) {
                Text(title)
                    .foregroundColor(isSelected ? Color.scheme.onBackground : .gray.opacity(0.8))
                    .font(.body)
                    .fontWeight(isSelected ? .bold : .medium)
                
                Rectangle()
                    .fill(isSelected ? Color.scheme.secondary : Color.scheme.background)
                    .frame(width: 20, height: 2)
            }
        }
        .padding(5)
    }
}

struct NewsCategoryItem_Previews: PreviewProvider {
    static var previews: some View {
        NewsCategoryItem(title: "Sports", isSelected: true) {
            
        }
    }
}
