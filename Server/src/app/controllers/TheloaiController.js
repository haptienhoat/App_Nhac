const Theloai = require('../model/Theloai')

class TheloaiController {
    index(req, res) {
        Theloai.find({})
            .then(theloai => res.json(theloai))
    }

    home(req, res) {
        res.render('theloai/home')
    }

    store(req, res, next) {
        const theloai = new Theloai(req.body)
        theloai.save()
            .then(() => res.redirect('/theloai/home'))
    }

    search(req, res) {
        Theloai.find({tentheloai: {'$regex': req.query.tukhoa}}, function(err, theloai) {
            if (!err) res.json(theloai)
            else res.status(400).json({error: 'error'})
        }) 
    }
}

module.exports = new TheloaiController;