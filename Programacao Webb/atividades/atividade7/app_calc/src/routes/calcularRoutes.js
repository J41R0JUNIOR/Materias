const express = require('express');
const router = express.Router();
const calculadoraController = require('../controller/calculadoraController');

router.get('/', calculadoraController.renderIndex);
router.post('/result', calculadoraController.calcular);

module.exports = router;
