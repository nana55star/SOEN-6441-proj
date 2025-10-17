package services;

import java.net.URLEncoder;
import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;

public class NewsService {
    private static final String BASE_URL = "https://newsapi.org/v2/everything";
    private final String apiKey;
    private final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(java.time.Duration.ofSeconds(10))
            .build();

    public static final class Response {
        public final int status;
        public final String body;
        public Response(int status, String body) {
            this.status = status; this.body = body;
        }
    }

    public NewsService() {
        this.apiKey = System.getenv("NEWS_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("NEWS_API_KEY is not set in this process environment.");
        }
    }

    public Response searchNewsWithStatus(String query) throws Exception {
        String q = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = BASE_URL + "?q=" + q + "&language=en&pageSize=20&sortBy=relevancy";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Api-Key", apiKey)   // preferred auth
                .GET()
                .timeout(java.time.Duration.ofSeconds(20))
                .build();

        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Response(res.statusCode(), res.body());
    }
}
