import { RegistrationForm } from "../../components/RegistrationForm/RegistrationForm"
import registrationStyle from "./UserRegistration.module.css"

export function UserRegistration() {

    return (
        <>
            <section className={`gradient-form ${registrationStyle.background}`}>
                <div className="container py-5 h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-xl-10">
                            <div className="card rounded-3 text-white">
                                <div className="row g-0">
                                    <div className="col-lg-6" style={{ backgroundColor: "#424242" }}>
                                        <div className="card-body p-md-5 mx-md-4">

                                            <div className="text-center">
                                                <img src="https://cdn-icons-png.flaticon.com/256/7548/7548292.png"
                                                    style={{ width: "185px" }} alt="logo" />
                                                <h4 className="mt-1 mb-5 pb-1">Registrati</h4>
                                            </div>

                                            <RegistrationForm />

                                        </div>
                                    </div>
                                    <div className={`col-lg-6 d-flex align-items-center ${registrationStyle.gradientCustom2}`}>
                                        <div className="px-3 py-4 p-md-5 mx-md-4">
                                            <h4 className="mb-4">Test Finale Gangemi Daniela</h4>
                                            <p className="small mb-0">In questa sezione è possibile registrarsi</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}