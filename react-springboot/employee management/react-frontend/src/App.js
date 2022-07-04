import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Footer from "./components/Footer";
import Header from "./components/Header";
import ListEmployees from "./components/ListEmployees"
import SharedLayout from "./components/SharedLayout";
import Home from "./components/Home";

function App() {
  return (
    <>

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<SharedLayout />}>
              <Route index element={<Home />} />
              <Route path="employees" element={<ListEmployees />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;


{/* <Header />
      <div className="container">
        <ListEmployees />
      </div>
      <Footer /> */}