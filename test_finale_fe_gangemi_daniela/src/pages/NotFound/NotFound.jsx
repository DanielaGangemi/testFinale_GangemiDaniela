import NotFoundStyle from "./NotFound.module.css"
import { Link } from "react-router-dom";

export function NotFound() {

    return (
        <>
            <div style={{ textAlign: 'center', marginTop: '50px' }}>
                <h1>404 - Pagina non trovata</h1>
                <p>Oops! La pagina che stai cercando non è disponibile.</p>
                <p>Torna alla <Link to="/">pagina principale</Link>.</p>
                <img src="https://png.pngtree.com/png-vector/20220511/ourmid/pngtree-error-404-page-not-found-png-image_4584735.png" alt="404" style={{ maxWidth: '100%', height: 'auto' }} />
            </div>

        </>
    );
}