const Casi = require('../model/Casi')

class CasiController {
    index(req, res) {
        Casi.find({}, function(err, casi) {
            if (!err) res.json(casi)
            else res.status(400).json({error: 'error'})
        }) 
    }

    home(req,res) {
        res.render('casi/home')
    }

    store(req, res, next) {
        const casi = new Casi(req.body)
        casi.save()
          .then(() => res.redirect('/casi/home'))
      }

      search(req, res) {
        Casi.find({tencasi: {'$regex': req.query.tukhoa}}, function(err, casi) {
            if (!err) res.json(casi)
            else res.status(400).json({error: 'error'})
        }) 
    }
}

module.exports = new CasiController;