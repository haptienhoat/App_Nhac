const express = require('express')
const app = express()
const port = 3000

const { engine } = require('express-handlebars');
const path = require('path');

const route = require('./routes')
const db = require('./config/db')

db.connect()

app.use(
  express.urlencoded({
    extended: true,
  }),
);
app.use(express.json());

app.engine(
  'hbs',
  engine({
    extname: '.hbs'
  }),
);
app.set('view engine', 'hbs');
app.set('views', path.join(__dirname, 'resources', 'views'));


route(app)

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})