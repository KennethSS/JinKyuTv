import SwiftUI
import shared
import UIKit
import Foundation
import Firebase

@main
struct iOSApp: App {

    @State var navigation = NavigationPath()
    @State var root = Destination.Splash

    init() {
        FirebaseApp.configure()
        KoinKt.doInitKoin()
    }
    

	var body: some Scene {
		WindowGroup {
            NavigationStack(path: $navigation) {
                
                switch root {
                case.Splash: 
                    SplashViewController(
                        navigateMain: {
                            root = Destination.Main
                        },
                        navigateSign: {
                            root = Destination.Login
                        }
                    )
                case.Login:
                    LoginViewController(
                        navigateMain: {
                            root = Destination.Main
                        },
                        navigateRegister: {
                            navigation.append(Destination.Register)
                        }
                    ).navigationDestination(for: Destination.self) { destination in
                        RegisterViewController(
                            navigateMain: {
                                navigation.removeLast(navigation.count)
                                root = Destination.Main
                            },
                            navigateLogin: { 
                                navigation.removeLast()
                            }
                        )
                    }
                default:
                    MainViewController()
                }
            }
		}
	}
}

enum Destination: Hashable {
    case Splash
    case Login
    case Register
    case Main
}
