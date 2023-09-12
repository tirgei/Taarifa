//
//  ThemeExtension.swift
//  iosApp
//
//  Created by Vincent Tirgei on 12/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    static let scheme = ColorScheme()
}

struct ColorScheme {
    let background = Color("BackgroundColor")
    let onBackground = Color("OnBackgroundColor")
    let primary = Color("PrimaryColor")
    let onPrimary = Color("OnPrimaryColor")
    let secondary = Color("SecondaryColor")
    let onSecondary = Color("OnSecondaryColor")
    let tertiary = Color("TertiaryColor")
    let onTertiary = Color("OnTertiaryColor")
}
