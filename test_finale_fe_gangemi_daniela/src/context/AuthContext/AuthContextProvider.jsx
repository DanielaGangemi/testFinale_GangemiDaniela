import { useState } from "react";
import { getClaimCookie } from "../../services/CookieService";
import { AuthContext } from "./AuthContext";

export function AuthContextProvider({ children }) {

    const { first_name, last_name, email, token } = getClaimCookie();

    const [user, setUser] = useState({

        name: first_name,
        surname: last_name,
        email: email,
        token: token,
        isAuthorized: token == null ? false : true

    })

    console.log(user)

    return (
        <>
            <AuthContext.Provider value={{ user, setUser }}>
                {children}
            </AuthContext.Provider>
        </>
    )


}