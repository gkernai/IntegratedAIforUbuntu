import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AiApp {// CLI Client that calls the Gemini 2.0 Flash Model via the Google AI HTTP API.
    private static final String APIKEY = "your-apıkey"; 
    private static final String APIURL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + APIKEY;
    public static void main(String[] args) throws IOException, InterruptedException { //he main entry point of the program. It processes command-line arguments.
        HttpClient client = HttpClient.newHttpClient();
		String question=(args.length>0)?args[0]:"Hi!!";// Checks if a question is provided as a command-line argument. Uses a default value ("Hi!") otherwise.

        
        String Requestbody = """
            {
              "contents": [{
                "parts": [{"text": "%s"}]
              }]
            }
            """.formatted(question);// The JSON body (payload) sent to the Gemini API. It contains the user's question and formatting.

        HttpRequest request = HttpRequest.newBuilder() // Builds the HTTP POST request, defining the API endpoint, the 'application/json' content type header, and the JSON request body.
                .uri(URI.create(APIURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(Requestbody))
                .build();

        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());// Sends the prepared request to the API and retrieves the response (status code, generated content).
        
        System.out.println("Status code: " + response.statusCode());// Prints the HTTP status code from the API and the generated text response from the model to the terminal.
        System.out.println("Response body: " + response.body());
    }
}
