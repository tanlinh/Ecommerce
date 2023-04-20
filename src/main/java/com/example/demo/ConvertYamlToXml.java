package com.example.demo;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import javax.net.ssl.*;
import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ConvertYamlToXml {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        System.out.println("run app... ");

        String dateString = "2023-03-29T03:13:43.634593Z";
        OffsetDateTime dateTime = OffsetDateTime.parse(dateString, DATE_TIME_FORMATTER);
        System.out.println("datetimeoffset "+dateTime);
        Instant instant = Instant.parse(dateTime.toString());
        Instant output = instant.truncatedTo(ChronoUnit.MILLIS);
        OffsetDateTime result =  OffsetDateTime.parse(output.toString()); output.atOffset(ZoneOffset.UTC);
        System.out.println(result);




//        OffsetDateTime.now();
//        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
//            public X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }};
//
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, new java.security.SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//        File schema = new File("D:\\demo\\src\\main\\resources\\schema.json");
//
//        JSONTokener jsonTokener = new JSONTokener(Files.newInputStream(schema.toPath()));
//        JSONObject jsonObject = new JSONObject(jsonTokener);
//
//        File data = new File("D:\\demo\\src\\main\\resources\\swagger.json");
//        JSONTokener jsonData = new JSONTokener(Files.newInputStream(data.toPath()));
//        JSONObject jsonObjectData= new JSONObject(jsonData);
//
//        Schema schemaValidate = SchemaLoader.load(jsonObject);
//        schemaValidate.validate(jsonObjectData);

    }
}
