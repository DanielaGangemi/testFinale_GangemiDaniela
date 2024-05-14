import footerStyle from "./Footer.module.css"

export function Footer() {

    return (
        <>
            <div className={footerStyle.footer}>
                <p className={footerStyle.copyright}> &copy; Daniela Gangemi. Tutti i diritti riservati.</p>
            </div>
        </>
    );
}