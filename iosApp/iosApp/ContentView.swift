import SwiftUI
import shared
import AVKit

struct ContentView: View {
    @State var player = AVPlayer()
    
    var body: some View {
        VideoPlayer(
            player: player
        )
        .frame(height: 400)
        .onAppear {
            player = AVPlayer(url:  URL(string: "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")!)
        }
        
		Text("gg")
        
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
    
