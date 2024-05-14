import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext/AuthContext";
import { setLoginCookie, setClaimCookie, getClaimCookie } from "../../services/CookieService";
import { login } from "../../services/RESTservice";
import { validateEmail, validatePassword } from "../../services/ValidationService";
import loginStyle from "./LoginForm.module.css";


export function LoginForm() {

    const [loginForm, setLoginForm] = useState({
        email: "",
        password: ""
    })

    const navigateTo = useNavigate();

    const handleChange = (event) => {

        const { name, value } = event.target;

        setLoginForm({ ...loginForm, [name]: value })

    }

    const handleRegistrationClick = (event) => {

        navigateTo("/registration")
    }

    const handleSubmit = async (event) => {

        event.preventDefault();
        console.log(loginForm)

        let validatedEmail = validateEmail(loginForm.email)
        let validatedPassword = validatePassword(loginForm.password)

        if (validatedEmail != null && validatedPassword != null) {

            // se sono rispettate le condizioni dettate dalla regex allora chiama l'endpoint
            const response = await login(loginForm)

            // controllo credenziali
            if (response == 0) {

                // setFlag(true);
                alert("errore 400")

            } else {

                let decodedToken = setLoginCookie(response)

                setClaimCookie(decodedToken);

                navigateTo("/home")

            }

        } else {

            // condizioni dettate dalla regex non rispettate
            alert("Email o password non rispettano i criteri")


        }

    }

    return (
        <>

            <form onSubmit={handleSubmit}>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="form2Example11">Email</label>
                    <input type="email" id="form2Example11" className="form-control"
                        placeholder="Indirizzo email" name="email" value={loginForm.email} onChange={handleChange} />

                </div>

                <div data-mdb-input-init className="form-outline mb-4">
                    <label className="form-label" htmlFor="form2Example22" >Password</label>
                    <input type="password" id="form2Example22" className="form-control" name="password" value={loginForm.password} onChange={handleChange} />

                </div>

                <div className="text-center pt-1 mb-5 pb-1">
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init className={`btn btn-lg btn-block ${loginStyle.backgroundButton}`} style={{ width: "100%" }}>Log
                        in</button>
                    <br></br>
                    {/* <a className="text-white" href="#!">Password dimenticata?</a> */}
                </div>

                <div className="d-flex align-items-center justify-content-center pb-4">
                    <p className="mb-0 me-2">Non hai un account?</p>
                    <button type="button" data-mdb-button-init data-mdb-ripple-init className="btn btn-outline-danger" onClick={handleRegistrationClick}>Iscriviti</button>
                </div>

            </form>

        </>
    );
}