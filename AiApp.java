import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AiApp {
    private static final String APIKEY = "your-apıkey"; 
    private static final String APIURL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + APIKEY;
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
		String question=(args.length>0)?args[0]:"How can i help you?";

        
        String Requestbody = """
            {
              "contents": [{
                "parts": [{"text": "%s"}]
              }]
            }
            """.formatted(question);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(Requestbody))
                .build();

        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
    }
}
