//
//  ComposeViewControllerToSwiftUi.swift
//  iosApp
//
//  Created by 송진광 on 12/23/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import shared



struct ComposeViewControllerToSwiftUi: UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> UIViewController {
    
        return Main_iosKt.ChatViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}
