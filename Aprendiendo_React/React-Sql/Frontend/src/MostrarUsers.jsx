import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BrowserRouter, Route } from "react-router-dom";
import { Login } from "./Login";
import { AddUser } from "./AddUser";

export function MostrarUsers() {
  const [data, setData] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8081/users")
      .then((res) => res.json())
      .then((data) => setData(data))
      .catch((err) => console.log(err));
  }, []);
  return (
    <div className="bd-table-container">
      <table className="bd-table-users">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Phone</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {data.map((d, i) => (
            <tr key={i}>
              <td>{d.id}</td>
              <td>{d.nombre}</td>
              <td>{d.phone}</td>
              <td>{d.email}</td>
              <td>delete</td>
            </tr>
          ))}
        </tbody>
      </table>

      <Link to="/login">Login</Link>
      <hr />
      <Link to="/add-user">ad user</Link>
    </div>
  );
}
