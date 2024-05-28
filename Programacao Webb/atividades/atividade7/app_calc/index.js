const express = require('express');
const mustacheExpress = require('mustache-express');
const app = express();

app.engine('html', mustacheExpress());
app.set('view engine', 'html');
app.set('views', __dirname + '/src/views');

app.use(express.urlencoded({extended: true}));

app.get('/', function(req, res){
    res.render('index.html');
});

app.post('/result', (req, res) => {
    const { fNumber, sNumber } = req.body;
    const result = parseFloat(fNumber) + parseFloat(sNumber);
    res.render('result', { fNumber, sNumber, result });
});



const PORT = 8080;
app.listen(PORT, function(){
    console.log('App running at ' + PORT);
});