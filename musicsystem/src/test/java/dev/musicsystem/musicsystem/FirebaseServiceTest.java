//package dev.musicsystem.musicsystem;
//
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.Storage;
//import dev.musicsystem.musicsystem.services.FirebaseService;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class FirebaseServiceTest {
//
//    @Test
//    public void testGetPathToFirebaseCred() throws IOException {
//        String pathToFirebaseCred = FirebaseService.getPathToFirebaseCred();
//
//        assertTrue(Files.exists(Paths.get(pathToFirebaseCred)), "Firebase credential file does not exist");
//        //assertTrue(FirebaseService.createFirebaseService() != null, "FirebaseApp object is null");
//    }
//
//    @Test
//    public void testGetFirebaseStorageImageUrl() {
//        // Tworzenie mocka Blob
//        Blob blob = mock(Blob.class);
//        when(blob.getMediaLink()).thenReturn("https://storage.googleapis.com/musicreviews.appspot.com/files/Californication.jpg");
//
//        // Tworzenie obiektu FirebaseService
//        FirebaseService firebaseService = new FirebaseService();
//
//        // Wywołanie metody getFirebaseStorageImageUrl z nazwą obrazu
//        //String imageUrl = firebaseService.getFirebaseStorageImageUrl("Californication.jpg");
//
//        // Sprawdzenie, czy zwrócony URL zawiera oczekiwany fragment
//        //assertEquals("https://storage.googleapis.com/musicreviews.appspot.com/files/Californication.jpg", imageUrl);
//    }
//}
//
