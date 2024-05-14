import registrationFormStyle from "./RegistrationForm.module.css"
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { validateEmail, validatePassword, validateNameOrSurname } from "../../services/ValidationService";
import { registration, getCityList } from "../../services/RESTservice";

export function RegistrationForm() {

    const [registrationForm, setRegistrationForm] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        cityId: ""
    })

    const [cityList, setCityList] = useState([]);

    useEffect(() => {

        async function findAll() {

            try {
                const cityData = await getCityList();

                setCityList(cityData);

            } catch (error) {

                console.error("Error fetching courses:", error);

            }
        }

        findAll();

    }, [])



    const navigateTo = useNavigate();

    const handleChange = (event) => {

        const { name, value } = event.target;

        setRegistrationForm({ ...registrationForm, [name]: value })

    }

    const handleChangeSelect = (event) => {

        const selectedCityId = event.target.value;

        setRegistrationForm({ ...registrationForm, cityId: selectedCityId });

    };

    const handleLoginClick = (event) => {

        navigateTo("/")

    }

    const handleSubmit = async (event) => {

        event.preventDefault();

        let validatedName = validateNameOrSurname(registrationForm.firstName);
        let validatedSurname = validateNameOrSurname(registrationForm.lastName)
        let validatedEmail = validateEmail(registrationForm.email)
        let validatedPassword = validatePassword(registrationForm.password)

        console.log(registrationForm)

        if (validatedName != null && validatedSurname != null && validatedEmail != null && validatedPassword) {

            // fare chiamata be
            const response = await registration(registrationForm);

            // controllare se non è andata a buon fine
            if (response == 0) {

                alert("Utente non valido")


            } else {

                navigateTo("/")

            }


        } else {

            alert("Dati inseriti non validi")


        }


    }

    return (
        <>

            <form onSubmit={handleSubmit}>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="formName">Nome</label>
                    <input type="text" id="formName" className="form-control"
                        placeholder="Nome" name="firstName" value={registrationForm.firstName} onChange={handleChange} />

                </div>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="formSurname">Cognome</label>
                    <input type="text" id="formSurname" className="form-control"
                        placeholder="Cognome" name="lastName" value={registrationForm.lastName} onChange={handleChange} />

                </div>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="form2Example11">Email</label>
                    <input type="email" id="form2Example11" className="form-control"
                        placeholder="Indirizzo email" name="email" value={registrationForm.email} onChange={handleChange} />

                </div>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="form2Example22" >Password</label>
                    <input type="password" id="form2Example22" className="form-control" name="password" value={registrationForm.password} onChange={handleChange} />

                </div>


                <div className="text-center pt-1 mb-5 pb-1">
                    <label className="form-label" htmlFor="formCitta" style={{ float: "left" }}>Città</label>
                    <select id="formCitta" className="form-select" value={registrationForm.cityId} onChange={handleChangeSelect}>
                        <option value=""></option>
                        {cityList.map((city) => (
                            <option key={city.idCity} value={city.idCity}>{city.name}</option>
                        ))}
                    </select>

                </div>

                <div className="text-center pt-1 mb-5 pb-1">
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init className={`btn btn-lg btn-block ${registrationFormStyle.backgroundButton}`} style={{ width: "100%" }}>
                        Registrati
                    </button>

                </div>

                <div className="d-flex align-items-center justify-content-center pb-4">
                    <p className="mb-0 me-2">Hai già un account?</p>
                    <button type="button" data-mdb-button-init data-mdb-ripple-init className="btn btn-outline-danger" onClick={handleLoginClick}>Accedi</button>
                </div>

            </form>
        </>
    );
}