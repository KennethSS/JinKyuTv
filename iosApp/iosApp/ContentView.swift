import SwiftUI
import shared
import AVKit

struct ContentView: View {
    @State var player = AVPlayer()

    var body: some View {
        ComposeLayer()
    }
}


struct MainView: View {
    var body: some View {
        MainViewControllerToSwiftUi()
            .ignoresSafeArea(.keyboard)
    }
}
