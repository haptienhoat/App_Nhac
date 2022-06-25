const Baihat = require('../model/Baihat')

class BaihatController {
    home(req,res) {
        res.render('baihat/home')
    }

    store(req, res, next) {
        const baihat = new Baihat(req.body)
        baihat.save()
          .then(() => res.redirect('/baihat/home'))
      }

    index(req, res) {
        Baihat.find({}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    id(req, res) {
        Baihat.find({idbaihat: req.query.idbaihat}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    album(req, res) {
        Baihat.find({idalbum: req.query.idalbum}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    theloai(req, res) {
        Baihat.find({idtheloai: req.query.idtheloai}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    casi(req, res) {
        Baihat.find({casi: req.query.casi}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    tacgia(req, res) {
        Baihat.find({tacgia: req.query.tacgia}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }

    search(req, res) {
        Baihat.find({tenbaihat: {'$regex': req.query.tukhoa}}, function(err, baihat) {
            if (!err) res.json(baihat)
            else res.status(400).json({error: 'error'})
        }) 
    }
}

module.exports = new BaihatController;