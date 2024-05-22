# FlightFinder Backend

This is the backend service for the FlightFinder application. It provides REST API endpoints for managing users, flights, prices, and favorites.

## Table of Contents

- [Project Description](#project-description)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Configuration](#configuration)
- [Testing](#testing)

## Project Description

The backend service for FlightFinder handles all server-side operations including user authentication, flight management, and data retrieval. It is built with Spring Boot and uses a MySQL database for data storage.

## Getting Started

### Prerequisites

- **Java JDK 17**
- **Apache Maven**
- **MySQL**

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/flightfinder.git
   cd flightfinder/backend
Backend
Controllers
HomeController
Handles requests to the home page and returns the main index.html.

UserController
Manages user-related operations such as registration and login.

FlightController
Handles all flight-related operations, including searching for available flights, retrieving flight details, and managing flight data.

FavouriteController
Manages user's favorite flights.

PriceController
Handles flight price-related queries.

DAOs (Data Access Objects)
UserDao
Manages database operations related to users.

FlightDao
Manages database operations related to flights.

FavouriteDao
Manages database operations related to favorite flights.

PriceDao
Manages database operations related to flight prices.

Entities
User
Represents a user in the system.

Flight
Represents a flight.

Favourite
Represents a user's favorite flight.

Price
Represents the price of a flight.

RowMappers
UserRowMapper
Maps database rows to User objects.

FlightRowMapper
Maps database rows to Flight objects.

FavouriteRowMapper
Maps database rows to Favourite objects.

PriceRowMapper
Maps database rows to Price objects.

Services
UserService
Contains business logic related to users.

FlightService
Contains business logic related to flights.

FavouriteService
Contains business logic related to favorite flights.

PriceService
Contains business logic related to flight prices.

Configuration
SecurityConfig
Configures security settings, allowing public access to the home page while protecting other endpoints.

Endpoints
User Endpoints
POST /register: Register a new user.
POST /login: Authenticate an existing user.
Flight Endpoints
GET /flights: Retrieve a list of available flights.
GET /flights/{id}: Retrieve details of a specific flight.
Favourite Endpoints
POST /favourites: Add a flight to favorites.
GET /favourites: Retrieve favorite flights for a user.
Price Endpoints
GET /prices: Retrieve flight prices.
Frontend
Architecture
Pages
Home Page: Access the home page at /home.
Login/Register: Use the login and register functionalities to create and access user accounts.
Search Flights: Use the search form to find available flights.
Favorites: Add flights to your favorites list and manage them.
Components
Header: Contains the navigation bar with links to different pages.
Banner: Displays the main slogan and search panel.
Search Panel: Allows users to search for flights with various filters.
Deals Section: Shows exclusive flight deals.
Footer: Contains social media links and contact information.
Screenshots


Testing
Postman Collection
A Postman collection for testing API endpoints is included.

Unit Tests
Java tests using JUnit and MockMvc are included for backend testing.