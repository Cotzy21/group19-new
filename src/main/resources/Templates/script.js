document.addEventListener('DOMContentLoaded', function () {
    const tripTypeBtn = document.getElementById('trip-type-btn');
    const tripTypeContent = document.getElementById('trip-type-content');
    tripTypeBtn.addEventListener('click', function () {
        tripTypeContent.style.display = tripTypeContent.style.display === 'block' ? 'none' : 'block';
    });

    const classBtn = document.getElementById('class-btn');
    const classContent = document.getElementById('class-content');
    classBtn.addEventListener('click', function () {
        classContent.style.display = classContent.style.display === 'block' ? 'none' : 'block';
    });

    const passengersBtn = document.getElementById('passengers-btn');
    passengersBtn.addEventListener('click', function () {
        const passengerContent = this.nextElementSibling;
        passengerContent.style.display = passengerContent.style.display === 'block' ? 'none' : 'block';
    });
});

function setTripType(type) {
    document.getElementById('trip-type-btn').innerText = type;
    document.getElementById('trip-type-content').style.display = 'none';
}

function setClass(classType) {
    document.getElementById('class-btn').innerText = classType;
    document.getElementById('class-content').style.display = 'none';
}

function increase(type) {
    const countElement = document.getElementById(type);
    let count = parseInt(countElement.textContent);
    count++;
    countElement.textContent = count;
}

function decrease(type) {
    const countElement = document.getElementById(type);
    let count = parseInt(countElement.textContent);
    if (count > 0) {
        count--;
        countElement.textContent = count;
    }
}

function searchFlights() {
    const tripType = document.getElementById('trip-type-btn').innerText;
    const passengers = {
        adults: document.getElementById('adults').innerText,
        children: document.getElementById('children').innerText,
        infants: document.getElementById('infants').innerText
    };
    const classType = document.getElementById('class-btn').innerText;
    const from = document.getElementById('from-input').value;
    const to = document.getElementById('to-input').value;
    const startDate = document.getElementById('start-date').value;
    const endDate = document.getElementById('end-date').value;

    const urlParams = new URLSearchParams({
        tripType: tripType,
        adults: passengers.adults,
        children: passengers.children,
        infants: passengers.infants,
        classType: classType,
        from: from,
        to: to,
        startDate: startDate,
        endDate: endDate
    });

    window.location.href = 'search.html?' + urlParams.toString();
}
