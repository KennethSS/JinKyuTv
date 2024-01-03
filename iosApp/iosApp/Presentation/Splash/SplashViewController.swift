
//
//  SplashViewController.swift
//  iosApp
//
//  Created by 송진광 on 12/28/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import shared

struct SplashViewController : UIViewControllerRepresentable {
    
    let navigateMain: () -> Void
    let navigateSign: () -> Void
    
    func makeUIViewController(context: Context) -> UIViewController {
        return Main_iosKt.SplashViewController(navigateMain: navigateMain, navigateSign: navigateSign)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}
