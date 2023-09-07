//
//  Extensions.swift
//  iosApp
//
//  Created by Vincent Tirgei on 07/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension View {
    @available(iOS, deprecated: 15.0, message: "This extension is no longer necessary. Use API built into SDK")
    func task(priority: TaskPriority = .userInitiated, _ action: @escaping @Sendable () async -> Void) -> some View {
        self.onAppear {
            Task(priority: priority) {
                await action()
            }
        }
    }
}
