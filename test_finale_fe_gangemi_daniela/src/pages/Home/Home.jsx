import { useContext, useEffect, useState } from "react";
import { AuthContext } from "../../context/AuthContext/AuthContext";
import { getUserByEmail, getWeatherForecastList } from "../../services/RESTservice";
import { TableWeatherForecast } from "../../components/TableWeatherForecast/TableWeatherForecast";

export function Home() {

    const { user } = useContext(AuthContext);

    const [cityList, setCityList] = useState([])


    useEffect(() => {

        async function getUserByEmailForCity() {

            try {
                const userByEmail = await getUserByEmail(user.email);

                let cityDataList = []

                userByEmail.cityList.forEach(async city => {

                    const cityData = await getWeatherForecastList(city.latitude, city.longitude);

                    cityData.cityName = city.name;

                    cityDataList.push(cityData)

                    setCityList(cityDataList);

                });


            } catch (error) {

                console.error("Error fetching:", error);

            }


        }


        getUserByEmailForCity()


    }, [])

    return (
        <>

            {cityList.map(city => (

                <div>

                    <h1 style={{textAlign: "center", marginTop: "2rem" }}>Meteo di {city.cityName}</h1>

                    <TableWeatherForecast City={city}></TableWeatherForecast>

                </div>

            ))}

        </>
    );
}