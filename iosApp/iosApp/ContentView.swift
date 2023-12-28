import SwiftUI
import shared
import AVKit

struct ContentView: View {
    @State var player = AVPlayer()
    
    var body: some View {
        ComposeLayer()
    }
}


struct ComposeLayer: View {
    var body: some View {
        ComposeViewControllerToSwiftUi()
            .ignoresSafeArea(.keyboard)
    }
}
