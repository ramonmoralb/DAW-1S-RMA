const express = require('express');
const mysql = require('mysql')
const cors = require('cors')

const app = express()
app.use(cors())

const db = mysql.createConnection({
    host: "localhost",
    user: 'root',
    password:'',
    database: 'crud'
}
)
app.get('/users', (req, res)=>{
    const sql = "SELECT * from users";
    db.query(sql, (err, data)=>{

        if(err) return res.json(err);
        return res.json(data);
    })
})
app.get('/users/:name', (req, res) => {
    const name = req.params.name;
    const sql = "SELECT * FROM users WHERE nombre = ?";
    db.query(sql, [name], (err, data) => {
        if (err) return res.json(err);
        return res.json(data);
    });
});

app.get('/' , (re,res) =>{
    return res.json(" Front backend side");
})

app.listen(8081, ()=>
    console.log('listen')
)