// LOGIN
export async function login(body) {

    const response = await fetch("http://localhost:8080/api/user/login", {
        mode: "cors",
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    })

    if (response.status !== 200) {
        return 0;
    }

    return await response.json();

}

// REGISTRATION
export async function registration(body) {


    const response = await fetch("http://localhost:8080/api/user/registration", {
        mode: "cors",
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    })

    if (response.status !== 200) {
        return 0;
    }

    return 1;

}

// GET CITIES LIST
export async function getCityList() {


    const response = await fetch("http://localhost:8080/api/city/all", {
        mode: "cors",
        method: "GET",

    })

    if (response.status != 200) {
        return 1;
    }

    return await response.json();



}

// GET USER BY EMAIL
export async function getUserByEmail(email) {


    const response = await fetch(`http://localhost:8080/api/user/show?email=${email}`, {
        mode: "cors",
        method: "GET",

    })

    if (response.status != 200) {
        return 1;
    }

    return await response.json();

}

// GET WEATHER FORECAST
export async function getWeatherForecastList(latitude, longitude){

    const response = await fetch("https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,relative_humidity_2m,precipitation_probability", {
        mode: "cors",
        method: "GET",

    })

    return await response.json();

}

