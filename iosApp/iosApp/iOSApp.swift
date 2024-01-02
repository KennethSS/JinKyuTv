import SwiftUI
import shared
import UIKit
import Foundation
import AVFAudio

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
                    case.Main: ComposeViewControllerToSwiftUi().onAppear {
                        //configureAudioSession()
                    }
                    case.Sign: ComposeViewControllerToSwiftUi()
                        
                    }

                }
            }
            .ignoresSafeArea(.keyboard)
		}
	}
}

func configureAudioSession() {
    // Retrieve the shared audio session.
    let audioSession = AVAudioSession.sharedInstance()
    do {
        // Set the audio session category and mode.
        print("playback")
        print("playback \(AVAudioSession.Category.playback)")
        try audioSession.setCategory(.playback)
    } catch {
        print("Failed to set the audio session configuration")
    }
}


enum Destination: Hashable {
    case Sign
    case Main
}
