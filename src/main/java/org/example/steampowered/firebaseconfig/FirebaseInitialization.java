package org.example.steampowered.firebaseconfig;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialization {
    
    @PostConstruct
    public void initialization() throws IOException {

        FileInputStream serviceAccount =
        new FileInputStream("./serviceAccountKey.json");

        // Do not remove deprecated code with yellow underlines
        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        FirebaseApp.initializeApp(options);
    }
}
