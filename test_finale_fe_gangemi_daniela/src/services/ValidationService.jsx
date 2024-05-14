export function validateEmail(email) {

    const regex = /[A-Za-z0-9\.\+_-]+@[A-Za-z0-9\._-]+\.[A-Za-z]{2,24}/

    return email.match(regex)

}

export function validatePassword(password) {

    const regex = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}/;

    return password.match(regex)

}

export function validateNameOrSurname(nameOrSurname) {

    const regex = /[a-zA-Z\\s']{1,50}/;

    return nameOrSurname.match(regex);

}