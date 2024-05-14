import { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext/AuthContext";
import { deleteCookies } from "../../services/CookieService";
import navbarStyle from "./Navbar.module.css";

export function Navbar() {

    const { user } = useContext(AuthContext);

    console.log(user)


    // console.log(user)

  

    const navigateTo = useNavigate();

    const handleLogout = async () => {

        // const response = await logout();

        // if (response == 1) {

        // cancellazione dei cookie
        deleteCookies()

        // ritorno alla login
        navigateTo("/")

        // } else {

        //     alert("Problemi interni al server")

        // }

    }


    return (
        <>
            <nav className={`navbar navbar-expand-lg ${navbarStyle.background}`} data-bs-theme="dark">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="" >
                        {user.name} {user.surname}
                    </Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">




                        {/* <div className="navbar-nav">
                            <Link className="nav-link" to="profile" >Profilo</Link>
                            <Link className="nav-link" to="courses/1" >Corsi</Link>
                        </div> */}


                        <div className="ms-auto">
                            <button className="btn btn-light" onClick={handleLogout}>Logout</button>
                        </div>



                    </div>
                </div>
            </nav>
        </>
    );
}