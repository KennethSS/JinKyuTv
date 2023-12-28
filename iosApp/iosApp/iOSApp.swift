import SwiftUI
import shared

@main
struct iOSApp: App {
    
    @State var navigation = NavigationPath()

    init() {
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
