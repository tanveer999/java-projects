import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListEmployees from "./components/ListEmployees"
import SharedLayout from "./components/SharedLayout";
import Home from "./components/Home";
import AddEmployee from "./components/AddEmployee";

function App() {
  return (
    <>

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<SharedLayout />}>
              <Route index element={<Home />} />
              <Route path="employees" element={<ListEmployees />} />
              <Route path="employee/add" element={<AddEmployee />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;