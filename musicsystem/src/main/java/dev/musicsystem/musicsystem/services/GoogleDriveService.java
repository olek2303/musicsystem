package dev.musicsystem.musicsystem.services;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.FileList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.api.services.drive.model.File;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class GoogleDriveService {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToGoogleCred();
    private static final String folderId = "1AWfin-1N-xnnAVWymv0-HnBdRDjFqVH7";
    private static Drive driveService;

    private static String getPathToGoogleCred() {
        String currentDir = System.getProperty("user.dir");
        currentDir += "/musicsystem/";
        Path filePath = Paths.get(currentDir, "cred.json");
        return filePath.toString();
    }

    public GoogleDriveService() {
        try {
            driveService = createDriveService();
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    private static Drive createDriveService() throws IOException, GeneralSecurityException {

        GoogleCredentials credential = GoogleCredentials.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        AccessToken token = credential.refreshAccessToken();
        String accessToken = token.getTokenValue();

        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credential);
        Drive service = new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                requestInitializer)
                .setApplicationName("MusicReviews")
                .build();

        return service;
    }

    public String getPhotoUrl(String fileName) throws IOException {
        List<File> files = driveService.files().list()
                .setQ("'" + folderId + "' in parents and trashed = false")
                .execute().getFiles();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return "https://drive.google.com/file/d/" + file.getId();
            }
        }

        return null;
    }

    public static ByteArrayOutputStream downloadFileByName(String fileName) throws IOException {
        Drive.Files.List request = driveService.files().list().setQ("name='" + fileName + "'");
        FileList files = request.execute();
        List<File> fileList = files.getFiles();

        if (fileList == null || fileList.isEmpty()) {
            throw new IOException("File not found: " + fileName);
        }

        File file = fileList.get(0);

        try {
            OutputStream outputStream = new ByteArrayOutputStream();

            driveService.files().get(file.getId())
                    .executeMediaAndDownloadTo(outputStream);

            return (ByteArrayOutputStream) outputStream;
        } catch (IOException e) {
            throw e;
        }
    }
}

