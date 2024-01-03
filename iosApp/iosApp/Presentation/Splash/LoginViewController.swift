//
//  LoginViewController.swift
//  iosApp
//
//  Created by 송진광 on 1/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginViewController : UIViewControllerRepresentable {
    
    let navigateMain: () -> Void
    let navigateRegister: () -> Void
    
    func makeUIViewController(context: Context) -> UIViewController {
    
        return Main_iosKt.LoginViewController(navigateRegister: navigateRegister, navigateMain: navigateMain)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
    
}

