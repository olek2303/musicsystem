package dev.musicsystem.musicsystem.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;
import com.google.firebase.cloud.StorageClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;

@Service
public class FirebaseService {

    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToFirebaseCred();
    private static FirebaseApp firebaseApp;

    public static String getPathToFirebaseCred() {
        String currentDir = System.getProperty("user.dir");
        currentDir += "/musicsystem/";
        Path filePath = Paths.get(currentDir, "fireCred.json");
        return filePath.toString();
    }

    public FirebaseService() {
        try {
            firebaseApp = createFirebaseService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private FirebaseApp createFirebaseService() throws IOException {
        String pathToToken = getPathToFirebaseCred();
        FileInputStream refreshToken = new FileInputStream(pathToToken);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .build();
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase app has been initialized");
            System.out.println("Path to token " + pathToToken);
        }
        return FirebaseApp.getInstance();
    }

//    public String getFirebaseStorageImageUrl(String imageName) {
//        Storage storage = StorageOptions.getDefaultInstance().getService();
//
//        String bucketName = "musicreviews.appspot.com";
//        String imagePath = imageName;
//        BlobId blobId = BlobId.of(bucketName, imagePath);
//        Blob blob = storage.get(blobId);
//
//        if (blob != null) {
//            return blob.getMediaLink();
//        } else {
//            return null; // Możesz obsłużyć ten przypadek zwracając null lub rzucając wyjątek
//        }
//    }

    public String getFirebaseStorageImageUrl(String imageName) throws IOException {
        FileInputStream serviceAccount = new FileInputStream(getPathToFirebaseCred());
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        Storage storage = StorageClient.getInstance().bucket("musicreviews.appspot.com").getStorage();
        String imagePath = imageName;
        Iterable<Blob> blobs = storage.list("musicreviews.appspot.com").iterateAll();

        System.out.println("Files in " + "musicreviews.appspot.com" + ":");
        for (Blob blob : blobs) {
            if (blob.getName().equals(imageName)) {
                return "https://firebasestorage.googleapis.com/v0/b/musicreviews.appspot.com/o/"+imageName+"?alt=media";

            }
            System.out.println(blob.getName());
        }

        return null;
    }

}
