//
//  VideoListViewController.swift
//  iosApp
//
//  Created by 송진광 on 1/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct VideoListViewController: UIViewControllerRepresentable {
    
    let navigatePlayer: (String) -> Void
    
    func makeUIViewController(context: Context) -> UIViewController {
    
        return Main_iosKt.VideoViewController(navigateMain: navigatePlayer)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }

    
    
}
