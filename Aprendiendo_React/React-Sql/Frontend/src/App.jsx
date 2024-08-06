import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { GetUserByName } from "./GetUserByName";
import { AddUser } from "./AddUser";
import { MostrarUsers } from "./MostrarUsers";
import { Login } from "./Login";

function App() {
  // de esta manera se establecen las rutas, y mediante el element, reenderiza el elemento(componente) deseado

  return (
    <Router>
      <Routes>
        <Route path="/" element={<MostrarUsers />} />
        <Route path="/get-user" element={<GetUserByName />} />
        <Route path="/add-user" element={<AddUser />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;
