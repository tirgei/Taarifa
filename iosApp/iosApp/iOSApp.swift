import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        AppHelperKt.doInitApp()
    }
 
	var body: some Scene {
		WindowGroup {
			HomeView()
		}
	}
}
