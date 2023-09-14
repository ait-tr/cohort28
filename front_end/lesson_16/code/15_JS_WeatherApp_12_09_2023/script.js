const API_KEY = "fa1e72ff893c6a4a5ed4077327e855b4";
const BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

const locationInput = document.getElementById("locationInput");
const getWeatherButton = document.getElementById("getWeatherButton");
const weatherContainer = document.getElementById("weatherContainer");

locationInput.addEventListener('keydown', (e) => {
    console.log(e);
    if (e.code === 'KeyA') {
        console.log('Мы нажали клавишу A');
    }
})

getWeatherButton.addEventListener('click', () => {
    const location = locationInput.value.trim();

    if (location) {
        const apiUrl = `${BASE_URL}?q=${location}&appid=${API_KEY}&units=metric`;

        fetch(apiUrl)
            .then(res => res.json())
            .then(data => displayWeather(data))

            .catch((err) => console.log(err))
            .finally(console.log("Запрос закончен!"));
    }
});

function displayWeather(weatherData) {
    const {
        name,
        sys: { country },
        main,
        main: { humidity: hum },
        weather,
        wind: { speed },
        visibility
    } = weatherData;

    weatherContainer.innerHTML = `
        <h2>${name}, ${country}</h2>
        <p>Temperature: ${main.temp}</p>
        <p>Max temperature: ${main.temp_max}</p>
        <p>Min temperature: ${main.temp_min}</p>
        <p>Weather: ${weather[0].main}</p>
        <p>Description: ${weather[0].description}</p>
        <p>Humidity: ${hum}</p>
        <p>Speed of wind: ${speed}</p>
        <p>Visibility: ${visibility}</p>
    `;
}