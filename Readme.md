#  School Web Application

Eazy School is a modern, server-side rendered web application built with Spring Boot. It serves as the primary informational website for a school, featuring dynamic content, user interaction forms, and a clean, responsive user interface.

## ✨ Features

* **Home Page:** A dynamic landing page introducing the school, its features, and statistics.
* **Contact Form:** A fully functional contact form that captures user inquiries and processes them in the backend.
* **Holidays Page:** Displays a list of school holidays, filterable by type (e.g., Festival, Federal).
* **Static Pages:** Simple, efficient routing for static content pages like "Courses" and "About Us".
* **Responsive UI:** Built on a professional template that is mobile-friendly.
* **Light/Dark Theme:** A theme-switcher for user preference.

## 🛠️ Technology Stack

This project is built using a modern, robust set of backend technologies:

* **Framework:** Spring Boot 3
* **Language:** Java 17
* **View Layer:** Thymeleaf
* **Web:** Spring MVC
* **Build Tool:** Maven
* **Developer Tools:** Spring Boot DevTools, Project Lombok
* **Server:** Embedded Tomcat

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java Development Kit (JDK) 17 or later
* Apache Maven
* An IDE like IntelliJ IDEA or Eclipse

### Installation

1.  **Clone the repository:**
    ```bash
    git clone <github.com/pcoolk/schoolapp>
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd schoolapp
    ```
3.  **Build the project using Maven:**
    ```bash
    mvn clean install
    ```
4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

The application will start on the embedded Tomcat server, typically on port `8080`. You can access it by navigating to `http://localhost:8080` in your web browser.

## 🏛️ Architecture

The application follows the classic **Model-View-Controller (MVC)** design pattern to ensure a clean separation of concerns.

* **Model:** Data objects (`Contact.java`, `Holiday.java`) that represent the application's data. Lombok is used to reduce boilerplate code (getters, setters, etc.).
* **View:** Thymeleaf templates (`.html` files) located in `src/main/resources/templates` that render the user interface.
* **Controller:** Classes in the `controller` package that handle incoming HTTP requests, process user input, interact with the service layer, and select a view to render.
* **Service:** The `service` layer contains the business logic. For example, `contactService` handles the processing of submitted contact forms.
