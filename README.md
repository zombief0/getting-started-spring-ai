# Getting Started: Simpsons Trivia

A small Spring Boot app that answers Simpsons trivia questions with an LLM (Spring AI, Groq's OpenAI-compatible API), plus a simple chat page.

## Features

- `GET /trivia?prompt=...` returns a Simpsons-only answer. Other topics get a refusal.
- A chat page at `/` (`src/main/resources/static/index.html`) with a Simpsons color theme.
- Past questions are listed on the right. Click one to see its saved answer. Everything is stored in the browser's local storage.

## Requirements

- Java 25
- A Groq API key

## Run

Set your API key, then start the app with the Maven wrapper:

```bash
export GROQ_API_KEY=your_key_here
./mvnw spring-boot:run
```

Then open http://localhost:8080/ in your browser, or query the endpoint directly:

```bash
curl "http://localhost:8080/trivia?prompt=Who%20voices%20Mr.%20Burns%3F"
```

## Configuration

Settings live in `src/main/resources/application.yaml`. The model is `openai/gpt-oss-120b`, served through `https://api.groq.com/openai/v1`.
