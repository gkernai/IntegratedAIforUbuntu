# IntegratedAIforUbuntu &  Gemini 2.0 Flash CLI Client


This project was born out of pure curiosity. It is designed to fetch and interact with the **Gemini 2.0 Flash** AI model via Google AI Studio.

The entire codebase was written using the **Pluma** text editor, and the logic is intentionally kept simple for ease of understanding.
WARNİNG!
To use this API, you need an API key from Google AI Studio. 



`## Usage

You can run the application in the Ubuntu terminal by passing your question as an argument:

```bash
java AiApp "Your question here"
When asking questions with multiple words, please enclose your query in double quotes. Since command-line arguments are space-delimited, failing to use quotes (e.g., java AiApp Hello World) may result in only the first word being processed.
```








##UPDATE
How to Install as a System Command (Linux/Ubuntu)

To run this application from anywhere in your terminal by just typing AI, follow these steps:
1. Create a Wrapper Script
Open your terminal and create a new file:
```bash
nano AI
```
2. Add the Execution Command:
 Copy and paste the following lines into the file. Note: Replace /home/chemax with the actual path where your .class files are located.
```bash
#!/bin/bash
java -cp "/home/username" AiApp "$@"
```
3. Make it Executable

Give the script permission to run:
```bash
chmod +x AI
```
4. Move to System Path

To make the command available globally (from any directory), move it to /usr/local/bin:
```bash
sudo mv AI /usr/local/bin/
```
5. Run the Application

Now you can launch the app from any folder by simply typing:
```bash
AI
```
Pro Tip: Using Aliases (Optional)

If you don't want to move files into system directories, you can add an alias to your .bashrc file:

    Run nano ~/.bashrc

    Add this line at the bottom: alias ai='java -cp "/home/chemax" AiApp'

    Run source ~/.bashrc





