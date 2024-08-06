import React, { useState } from "react";

const AddUser = () => {
  const [id, setId] = useState("");
  const [nombre, setNombre] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleSubmit = (event) => {
    event.preventDefault(); // elimina accioner por defecto en este caso del form

    // valoda los datos
    if (!id || !nombre || !phone || !email) {
      setError("Todos los campos son requeridos");
      return;
    }

    fetch("http://localhost:8081/addUser", {
      // apunta al controlador
      method: "POST", // metodo
      headers: {
        // investigar , ayuda la ia
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id, nombre, phone, email }),
    })
      .then((response) => {
        if (response.ok) {
          return response.text();
        } else {
          throw new Error("Error en la respuesta del servidor");
        }
      })
      .then((result) => {
        setSuccess(result);
        setError(null);
        //limpieza del formulario, se puede hacer un metodo mas limpop
        setId("");
        setNombre("");
        setPhone("");
        setEmail("");
      })
      .catch((error) => {
        setError(error.message);
        setSuccess(null);
      });
  };

  return (
    <div className="adda">
      <h1>Agregar Usuario</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="id">ID:</label>
          <input
            id="id"
            type="number"
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="nombre">Nombre:</label>
          <input
            id="nombre"
            type="text"
            value={nombre}
            onChange={(e) => setNombre(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="phone">Teléfono:</label>
          <input
            id="phone"
            type="number"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input
            id="email"
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <button type="submit">Añadir Usuario</button>
      </form>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {success && <p style={{ color: "green" }}>{success}</p>}
    </div>
  );
};

export default AddUser;
