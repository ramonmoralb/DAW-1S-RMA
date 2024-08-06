const express = require('express');
const mysql = require('mysql');
const cors = require('cors');
const bodyParser = require('body-parser'); // Asegúrate de instalar body-parser

const app = express();
app.use(cors());
app.use(express.json()); // Middleware para analizar el cuerpo de solicitudes JSON

// Configuración de la conexión a la base de datos
const db = mysql.createConnection({
    host: "localhost",
    user: 'root',
    password: '',
    database: 'crud'
});

// Conexión a la base de datos
db.connect(err => {
    if (err) {
        console.error('Error conectando a la base de datos:', err);
        process.exit(1);
    }
    console.log('Conectado a la base de datos MySQL');
});

// Ruta para obtener todos los usuarios
app.get('/users', (req, res) => {
    const sql = "SELECT * FROM users";
    db.query(sql, (err, data) => {
        if (err) return res.status(500).json(err);
        return res.json(data);
    });
});

// Ruta para obtener usuarios por nombre
app.get('/users/:name', (req, res) => {
    const name = req.params.name;
    const sql = "SELECT * FROM users WHERE nombre = ?";
    db.query(sql, [name], (err, data) => {
        if (err) return res.status(500).json(err);
        return res.json(data);
    });
});

// Ruta raíz
app.get('/', (req, res) => {
    return res.json("Front backend side");
});

// Ruta POST para añadir usuarios
app.post('/AddUser', (req, res) => {
    const { id, nombre, phone, email } = req.body;
    
    // Validación básica de datos
    if (!id || !nombre || !phone || !email) {
        return res.status(400).send('Todos los campos son requeridos');
    }

    const query = 'INSERT INTO users (id, nombre, phone, email) VALUES (?, ?, ?, ?)';
    db.query(query, [id, nombre, phone, email], (err, result) => {
        if (err) {
            console.error('Error al ejecutar la consulta:', err);
            return res.status(500).send('Error al añadir el registro');
        }
        res.status(200).send('Registro añadido con éxito');
    });
});


// Inicia el servidor en el puerto 8081
app.listen(8081, () => {
    console.log('Servidor corriendo en http://localhost:8081');
});
