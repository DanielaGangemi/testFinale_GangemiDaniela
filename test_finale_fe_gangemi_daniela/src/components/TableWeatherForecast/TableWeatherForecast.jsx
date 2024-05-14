import { format } from 'date-fns';
import { it } from 'date-fns/locale';

export function TableWeatherForecast(props) {

    return (
        <>


            <table className={`table ${TableWeatherForecastStyle.tableStyle}`}>
                <thead>
                    <tr>
                        <th scope="col">Giorno e ora</th>
                        <th scope="col">Temperatura ({props.City.hourly_units.temperature_2m}) </th>
                        <th scope="col">Umidità relativa ({props.City.hourly_units.relative_humidity_2m})</th>
                        <th scope="col">Probabilità di precipitazioni ({props.City.hourly_units.precipitation_probability})</th>
                    </tr>
                </thead>
                <tbody>
                    {props.City.hourly.time.map((time, index) => (

                        <tr>
                            <td>{format(time, "dd/MM/yyyy 'ore' HH:mm", { locale: it })}</td>
                            <td>{props.City.hourly.temperature_2m[index]}</td>
                            <td>{props.City.hourly.relative_humidity_2m[index]}</td>
                            <td>{props.City.hourly.precipitation_probability[index]}</td>
                        </tr>

                    ))}

                </tbody>
            </table>

        </>
    );
}