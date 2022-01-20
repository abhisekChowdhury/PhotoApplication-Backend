//package com.example.getmesocialservice.config;
//
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Configuration
//public class FirebaseConfigCOPY {
//
//    @Bean
//    public FirebaseApp intializeFirebase() throws IOException {
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resolver.getResource("classpath:photoapplication-spring2-44173-firebase-adminsdk-m6fhf-90f85abe4f.json");
//
//        FileInputStream serviceAccount =
//                new FileInputStream(resource.getFile());
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//     /*   if(FirebaseApp.getApps().isEmpty()) { //<--- check with this line
//            return FirebaseApp.initializeApp(options);
//        }
//        return  FirebaseApp.getApps().get(0);*/
//
//        return FirebaseApp.initializeApp(options);
//
//    }
//
//
//
//}
