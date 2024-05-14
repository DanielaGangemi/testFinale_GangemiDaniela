import Cookies from 'js-cookie';
import { jwtDecode } from 'jwt-decode';


export function setLoginCookie(jwtToken) {

    const { token, ttl, tokenCreationTime } = jwtToken;

    const expire = new Date(ttl);

    Cookies.set("token", token, { expires: expire })

    return jwtDecode(token)

}

export function setClaimCookie(token) {

    const { first_name, last_name, email } = token;

    Cookies.set("first_name", first_name);
    Cookies.set("last_name", last_name);
    Cookies.set("email", email);




}

export function getClaimCookie() {

    const userData = {
        first_name: Cookies.get("first_name"),
        last_name: Cookies.get("last_name"),
        email: Cookies.get("email"),
        token: Cookies.get("token")
    }

    return userData;

}

export function deleteCookies() {

    Cookies.remove("name");
    Cookies.remove("surname");
    Cookies.remove("email");
    Cookies.remove("roles");
    Cookies.remove("token");
    
}