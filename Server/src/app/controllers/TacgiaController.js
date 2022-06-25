const Tacgia = require('../model/Tacgia')

class TacgiaController {
    index(req, res) {
        Tacgia.find({})
        .then(tacgia => res.json(tacgia))
    }

    home(req,res) {
        res.render('tacgia/home')
    }

    store(req, res, next) {
        const tacgia = new Tacgia(req.body)
        tacgia.save()
          .then(() => res.redirect('/tacgia/home'))
      }

      search(req, res) {
        Tacgia.find({tentacgia: {'$regex': req.query.tukhoa}}, function(err, tacgia) {
            if (!err) res.json(tacgia)
            else res.status(400).json({error: 'error'})
        }) 
    }
}

module.exports = new TacgiaController;