//
//  PlayerViewController.swift
//  iosApp
//
//  Created by 송진광 on 1/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import shared

struct PlayerViewController: UIViewControllerRepresentable {
    
    let url: String
    
    func makeUIViewController(context: Context) -> UIViewController {
    
        return Main_iosKt.PlayerViewController(url: url)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }

    
    
}
