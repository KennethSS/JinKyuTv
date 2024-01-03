import SwiftUI
import shared
import UIKit
import Foundation
import Firebase

@main
struct iOSApp: App {

    @State var navigation = NavigationPath()

    init() {
        FirebaseApp.configure()
        KoinKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            NavigationStack(path: $navigation) {
                SplashViewController(
                    navigateMain: { navigation.append(Destination.Main) },
                    navigateSign: { navigation.append(Destination.Sign) }
                ).navigationDestination(for: Destination.self) { destination in
                    switch destination {
                    case.Main: ComposeViewControllerToSwiftUi()
                    case.Sign: ComposeViewControllerToSwiftUi()
                    }
                }
            }
            .ignoresSafeArea(.keyboard)
		}
	}
}

enum Destination: Hashable {
    case Sign
    case Main
}
