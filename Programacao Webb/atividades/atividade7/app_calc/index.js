const express = require('express');
const mustacheExpress = require('mustache-express');
const path = require('path');
const app = express();

// Configurações
app.engine('html', mustacheExpress());
app.set('view engine', 'html');
app.set('views', path.join(__dirname, 'src', 'views'));
app.use(express.urlencoded({ extended: true }));

// Rotas
const calculadoraRoutes = require('./src/routes/calcularRoutes');
app.use('/', calculadoraRoutes);

const PORT = 8080;
app.listen(PORT, function(){
    console.log(`App running at ${PORT}`);
});
