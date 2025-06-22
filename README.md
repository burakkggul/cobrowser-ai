# CoBrowser AI

CoBrowser AI is an API for browser automation using prompts. It allows you to control and automate browser actions by sending natural language instructions to the API. This project is designed to make browser automation easy and accessible through simple prompt-based commands.

## Features
- Prompt-driven browser automation
- RESTful API endpoints
- Easily extensible for new browser actions

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven
- Azure OpenAI credentials

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/burakkggul/cobrowser-ai.git
   cd browser-ai
   ```
2. Configure your Azure OpenAI credentials in `src/main/resources/application.properties`:
   ```properties
   spring.ai.azure.openai.api-key=YOUR_API_KEY
   spring.ai.azure.openai.endpoint=YOUR_ENDPOINT
   ```
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Example Usage
Send a prompt to the API to automate browser actions, such as navigating to a website, clicking buttons, or filling forms.

## Contributing
Contributions are welcome! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License
This project is licensed under the LGPL v2.1 License.
