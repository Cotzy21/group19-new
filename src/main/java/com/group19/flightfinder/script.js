// Toggle mobile menu
function toggleMenu() {
    const nav = document.getElementById('mobile-nav');
    nav.classList.toggle('show');
}

// Simulate a fetch request to get flight data (mock function)
function getFlightData(searchParams) {
    // Normally, you would use fetch() or axios to get data from your backend.
    // Here we simulate a delay like an async call.
    return new Promise(resolve => {
        setTimeout(() => {
            resolve([
                { id: 1, from: 'OSL', to: 'AMS', depart: '2024-07-21', price: '99 EUR' },
                { id: 2, from: 'OSL', to: 'NYC', depart: '2024-08-15', price: '299 USD' },
                // ...add more mock flights
            ]);
        }, 1000);
    });
}

// Render flights to the DOM
function renderFlights(flights) {
    const resultsContainer = document.getElementById('search-results');
    resultsContainer.innerHTML = ''; // Clear previous results

    flights.forEach(flight => {
        const flightElement = document.createElement('div');
        flightElement.className = 'flight-result';
        flightElement.innerHTML = `
            <h2>${flight.from} to ${flight.to}</h2>
            <p>Departure: ${flight.depart}</p>
            <p>Price: ${flight.price}</p>
        `;
        resultsContainer.appendChild(flightElement);
    });
}

// Handle search form submission
document.getElementById('search-form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const leavingFrom = document.getElementById('leaving-from').value;
    const goingTo = document.getElementById('going-to').value;
    const departing = document.getElementById('departing').value;
    const returning = document.getElementById('returning').value;

    // Assuming getFlightData is an API call to your backend
    const flights = await getFlightData({ leavingFrom, goingTo, departing, returning });
    renderFlights(flights);
});

// Initial call to load some default flight data
getFlightData().then(renderFlights);
