import { useEffect, useState } from "react";

export function GetUserByName() {
  const [name, setName] = useState("");
  const [data, setData] = useState([]);
  const [search, setSearch] = useState(false);

  useEffect(() => {
    if (search && name.trim() !== "") {
      fetch(`http://localhost:8081/users/${name}`)
        .then((res) => res.json())
        .then((data) => {
          setData(data);
          setSearch(false);
        })
        .catch((err) => {
          console.log(err);
          setSearch(false);
        });
    }
  }, [search, name]);

  const handleInputChange = (event) => {
    setName(event.target.value);
  };

  const handleSearchClick = () => {
    setSearch(true);
  };

  return (
    <div className="buscador">
      <label htmlFor="Nombre">Nombre a buscar:</label>
      <input
        placeholder="nombre..."
        type="text"
        value={name}
        onChange={handleInputChange}
      />
      <button onClick={handleSearchClick}>Buscar</button>
      {data.length > 0 && ( // renderizado condicional de ser true mostrará la tabla
        <table>
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
              </tr>
            ))}
          </tbody>
        </table>
      )}

      <div>
        {data.map((d, index) => (
          <p key={index}>Nombre = {d.nombre.toUpperCase()}</p>
        ))}
      </div>
    </div>
  );
}
