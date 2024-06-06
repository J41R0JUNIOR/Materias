const Usuario = require('../model/usuario');

function indexView(req, res){
    res.render('index.html');
}

function criarContaView(req, res){
    res.render('usuario_cadastro.html');
}

function cadastrarUsuario(req, res){
    let usuario = {
        email: req.body.email,
        senha: req.body.senha,
        perfil: req.body.perfil
    }

    // console.log(usuario);
    Usuario.create(usuario).then(()=> {
        res.redirect('/?cadastrar_usuario=true');
    }).catch((err)=>{
        console.log(err)
        res.redirect('/?cadastrar_usuario=false');
    });
}

module.exports = {
    indexView, 
    criarContaView, 
    cadastrarUsuario
}