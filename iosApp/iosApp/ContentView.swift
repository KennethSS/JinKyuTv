import SwiftUI
import shared
import AVKit

struct ContentView: View {
    @State var player = AVPlayer()
    
    let greet = Greeting().greeting()
    
    var body: some View {
        ComposeLayer()
        Text(greet)
    }
}


struct ComposeLayer: View {
    var body: some View {
        ComposeViewControllerToSwiftUi()
            .ignoresSafeArea(.keyboard)
    }
}
