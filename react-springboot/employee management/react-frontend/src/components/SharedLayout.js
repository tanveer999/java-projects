import { Outlet } from "react-router-dom"
import Footer from "./Footer"
import Header from "./Header"


function SharedLayout() {
    return (
        <>
            <Header />
            <div className="container">
                <Outlet />
            </div>
            <Footer />
        </>
    )
}

export default SharedLayout