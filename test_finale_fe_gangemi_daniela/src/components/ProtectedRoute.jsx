import { AuthContext } from "../context/AuthContext/AuthContext";
import { useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";

export function ProtectedRoute({ children }) {

    const { user } = useContext(AuthContext);
    const navigateTo = useNavigate();

    console.log(user)

    useEffect(() => {


        if (!user.isAuthorized) {

            navigateTo("/")

        }

    })

    return (
        <>
            {children}
        </>
    );


}